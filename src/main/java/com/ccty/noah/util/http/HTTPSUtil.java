package com.ccty.noah.util.http;

import com.ccty.noah.aop.aspect.exception.NoahException;
import com.ccty.noah.constants.ExceptionType;
import org.apache.http.client.HttpClient;

import java.util.HashMap;

/**
 * http工具类
 * @author 缄默
 * @date 2020/06/08
 */
public class HTTPSUtil {

    /**
     * 根据url返回内容
     * @param url 请求地址
     * @return 响应
     */
    public static String doGetByUrl(String url){
        try{
            HttpClient httpClient = new HTTPSTrustClient().init();
            return HTTPSClientUtil.doGet(httpClient, url, new HashMap<>(2),new HashMap<>(2));
        }catch (Exception e){
            throw new NoahException(ExceptionType.HTTP_GET_URL_ERROR.getCode(),ExceptionType.HTTP_GET_URL_ERROR.getName());
        }
    }

}
