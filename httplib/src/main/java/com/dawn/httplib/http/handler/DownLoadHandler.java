package com.dawn.httplib.http.handler;

import com.dawn.httplib.http.exception.HttpException;
import com.dawn.httplib.http.request.OkRequest;
import com.dawn.httplib.http.response.OkResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import io.reactivex.ObservableEmitter;
import okhttp3.Call;
import okhttp3.Response;

import static com.dawn.httplib.http.exception.HttpException.DOWNLOAD_ERROR_CODE;
import static com.dawn.httplib.http.exception.HttpException.DOWNLOAD_ERROR_MSG;

/**
 * 处理下载
 */

public class DownLoadHandler {
    public static void downLoad(Call call, OkRequest request, final ObservableEmitter<OkResponse> emitter) {
        InputStream is = null;
        FileOutputStream fos = null;
        OkResponse okResponse = null;
        try {

            File parenFile = new File(request.getDownLoadDir());
            if (!parenFile.exists()) {
                parenFile.mkdirs();
            }
            final File file = new File(parenFile, request.getFileName());
            if (file.exists()) {
                file.delete();
            }
            Response response = call.execute();
            okResponse = new OkResponse(request, response, "这是一个下载的响应结果");
            byte[] buf = new byte[2048];
            int len;
            long total = response.body().contentLength();
            long current = 0;
            is = response.body().byteStream();
            fos = new FileOutputStream(file);
            while ((len = is.read(buf)) != -1) {
                current += len;
                fos.write(buf, 0, len);
                okResponse.setTotalSize(total);
                okResponse.setCurrentSize(current);
                int progress = (int) (current * 1.0f / total * 100);
                okResponse.setPercent(progress);
                emitter.onNext(okResponse);
            }
            fos.flush();
        } catch (IOException e) {
            HttpException exception = new HttpException(DOWNLOAD_ERROR_CODE, DOWNLOAD_ERROR_MSG);
            exception.setOkResponse(okResponse);
            emitter.onError(exception);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
