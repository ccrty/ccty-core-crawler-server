package com.jianmo.crawler.constants;

/**
 * @author  缄默
 * @date 2019/12/27
 */
public enum HTTPStatusEnum {
    //http状态码
    CONTINUE(100,"客户端继续其请求"),
    SWITCHING_PROTOCOLS(101,"切换协议"),
    PROCESSING(102,"处理将被继续执行"),
    SUCCESS(200,"请求成功"),
    CREATED(201,"成功请求并创建了新的资源"),
    ACCEPTED(202,"已经接受请求,但未处理完成"),
    NON_AUTHORITATIVE_INFORMATION(203,"非授权信息"),
    NO_CONTENT(204,"无内容"),
    RESET_CONTENT(205,"重置内容"),
    PARTIAL_CONTENT(206,"部分请求成功"),
    MULTI_STATUS(207,"消息体将是一个XML消息"),
    MULTIPLE_CHOICES(300,"请求的资源可包括多个位置"),
    MOVED_PERMANENTLY(301,"请求的资源已被永久的移动到新URI"),
    MOVE_TEMPORARILY(302,"资源临时被移动,客户端继续使用原有URI"),
    SEE_OTHER(303,"使用其他请求方式请求"),
    NOT_MODIFIED(304,"请求资源为修改"),
    USE_PROXY(305,"所请求的资源必须通过代理访问"),
    UNUSED(306,"已经被废弃"),
    TEMPORARY_REDIRECT(307,"临时重定向"),
    BAD_REQUEST(400,"请求语法错误"),
    UNAUTHORIZED(401,"请求需要身份认证"),
    PAYMENT_REQUIRED(402,"保留"),
    FORBIDDEN(403,"服务器拒绝执行请求"),
    NOT_FOUND(404,"请求资源不存在"),
    METHOD_NOT_ALLOWED(405,"客户端请求中的方法被禁止"),
    NOT_ACCEPTABLE(406,"服务器无法根据客户端请求的内容特性完成请求"),
    PROXY_AUTHENTICATION_REQUIRED(407,"请求要求代理的身份认证"),
    REQUEST_TIME_OUT(408,"请求超时"),
    CONFLICT(409,"服务器请求时发生了冲突"),
    GONE(410,"客户端请求的资源已经不存在"),
    LENGTH_REQUIRED(411,"服务器无法处理客户端发送的不带Content-Length的请求信息"),
    PRECONDITION_FAILED(412,"客户端请求信息的先决条件错误"),
    REQUEST_ENTITY_TOO_LARGE(413,"请求实体过大"),
    REQUEST_URI_TOO_LARGE(414,"请求的URI过长"),
    UNSUPPORTED_MEDIA_TYPE(415,"服务器无法处理请求附带的媒体格式"),
    REQUESTED_RANGE_NOT_SATISFIABLE(416,"客户端请求的范围无效"),
    EXPECTATION_FAILED(417,"服务器无法满足Expect的请求头信息"),
    INTERNAL_SERVER_ERROR(500,"服务器内部错误"),
    NOT_IMPLEMENTED(501,"服务器不支持请求的功能"),
    BAD_GATEWAY(502,"网关错误"),
    SERVICE_UNAVAILABLE(503,"系统维护或超载"),
    GATEWAY_TIME_OUT(504,"网关超时"),
    HTTP_VERSION_NOT_SUPPORTED(505,"服务器不支持请求的HTTP协议的版本，无法完成处理");

    private int code;

    private String description;

    HTTPStatusEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static String getDesc(int code){
        for(HTTPStatusEnum httpEnum : HTTPStatusEnum.values()){
            if(httpEnum.code==code){
                return httpEnum.description;
            }
        }
        return "http请求错误";
    }
}
