package com.ccty.noah.constants;

/**
 * @author 缄默
 * @date 2019/12/25
 */
public enum ExceptionType {

    //http请求
    HTTP_NO_RESPONSE("101","http请求无响应"),
    HTTP_RESPONSE_ERROR("102","http请求异常，响应码为："),
    HTTP_GET_URL_ERROR("103","http请求异常"),
    GET_QUNAER_ARTICLE_ERROR("104","获取去哪儿网站文章内容为空");

    private String code;

    private String name;

    ExceptionType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }}
