package com.example.lib;

/**
 * Created by wind on 16/8/31 13:07
 */
public class BaseResult<T> {

	public T data;

	public String code;

	public String msg;

	public String action;

	@Override
	public String toString() {
		return "HttpResult{" +
				" data=" + data +
				", code='" + code + '\'' +
				", msg='" + msg + '\'' +
				", action='" + action + '\'' +
				'}';
	}
}
