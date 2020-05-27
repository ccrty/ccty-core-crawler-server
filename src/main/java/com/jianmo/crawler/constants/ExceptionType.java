package com.jianmo.crawler.constants;

/**
 * @author 缄默
 * @date 2019/12/25
 */
public enum ExceptionType {

    //http请求
    HTTP_NO_RESPONSE(101,"http请求无响应"),
    HTTP_RESPONSE_ERROR(102,"http请求异常，响应码为："),
    HTTP_RESPONSE_NULL(103,"http请求异常，返回数据为空");

    private int code;

    private String name;

    ExceptionType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }}
