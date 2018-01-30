package com.dawn.httplib.http.factory;


import com.dawn.httplib.http.strategy.IHttpStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/22 0022.
 */

public class StrategyFactory {
    private static Map<String, IHttpStrategy> sMap = new HashMap<>();

    public static  <T extends IHttpStrategy> T createStrategy(Class<T> clazz) {
        IHttpStrategy strategy = null;
        if (sMap.containsKey(clazz.getName()))
            strategy = sMap.get(clazz.getName());
        else {
            try {
                strategy = (IHttpStrategy) Class.forName(clazz.getName()).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            sMap.put(clazz.getName(), strategy);
        }
        return (T) strategy;
    }


}
