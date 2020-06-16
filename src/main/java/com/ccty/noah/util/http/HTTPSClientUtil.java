package com.ccty.noah.util.http;

import com.ccty.noah.aop.aspect.exception.NoahException;
import com.ccty.noah.constants.ExceptionType;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.*;

/**
 * @author 缄默
 * @date 2019/12/23
 */
public class HTTPSClientUtil {
    private static final String DEFAULT_CHARSET = "UTF-8";

    /**
     * delete请求
     * @param httpClient
     * @param url
     * @param paramHeader
     * @param paramBody
     * @return
     * @throws Exception
     */
    public static String doDelete(HttpClient httpClient, String url, Map<String, Object> paramHeader,
                                Map<String, Object> paramBody) throws Exception {
        return doDelete(httpClient, url, paramHeader, paramBody, DEFAULT_CHARSET);
    }

    /**
     * 表单请求
     * @param httpClient
     * @param url
     * @param paramHeader
     * @param paramBody
     * @param charset
     * @return
     * @throws Exception
     */
    public static String doDelete(HttpClient httpClient, String url,Map<String, Object> paramHeader,
                                Map<String, Object> paramBody, String charset) throws Exception {

        HttpDelete httpDelete = new HttpDelete(url);
        //设置请求头
        setHeader(httpDelete, paramHeader);
        HttpResponse response = httpClient.execute(httpDelete);
        //校验响应码
        validCode(response);
        //获取响应信息
        return getResponse(response,charset);
    }

    /**
     * 表单请求
     * @param httpClient
     * @param url
     * @param paramHeader
     * @param paramBody
     * @return
     * @throws Exception
     */
    public static String doPost(HttpClient httpClient, String url, Map<String, Object> paramHeader,
                                Map<String, Object> paramBody) throws Exception {
        return doPost(httpClient, url, paramHeader, paramBody, DEFAULT_CHARSET);
    }

    /**
     * 表单请求
     * @param httpClient
     * @param url
     * @param paramHeader
     * @param paramBody
     * @param charset
     * @return
     * @throws Exception
     */
    public static String doPost(HttpClient httpClient, String url,Map<String, Object> paramHeader,
                                Map<String, Object> paramBody, String charset) throws Exception {

        HttpPost httpPost = new HttpPost(url);
        //设置请求头
        setHeader(httpPost, paramHeader);
        //设置请求体
        setBody(httpPost, paramBody, charset);
        HttpResponse response = httpClient.execute(httpPost);
        //校验响应码
        validCode(response);
        //获取响应信息
        return getResponse(response,charset);
    }

    /**
     * 请求体请求
     * @param httpClient
     * @param paramHeader
     * @param url
     * @param strJson
     * @return
     * @throws Exception
     */
    public static String doPostJson(HttpClient httpClient,String url, Map<String, Object> paramHeader,String strJson) throws Exception {
        return doPostJson(httpClient, url,paramHeader, strJson, DEFAULT_CHARSET);
    }

    /**
     * 请求体请求
     * @param httpClient
     * @param paramHeader
     * @param url
     * @param strJson
     * @return
     * @throws Exception
     */
    public static String doPostXml(HttpClient httpClient,String url, Map<String, Object> paramHeader,String strJson) throws Exception {
        return doPostXml(httpClient, url,paramHeader, strJson, DEFAULT_CHARSET);
    }

    /**
     * 请求体请求
     * @param httpClient
     * @param url
     * @param paramHeader
     * @param strJson
     * @param charset
     * @return
     * @throws Exception
     */
    public static String doPostJson(HttpClient httpClient, String url,Map<String, Object> paramHeader, String strJson, String charset) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        //设置请求头
        setHeader(httpPost,paramHeader);
        //设置请求方式
        httpPost.addHeader("Content-Type",ContentType.APPLICATION_JSON.getMimeType());
        //参数编码方式和类型
        StringEntity entity = new StringEntity(strJson);
        return groupRequest(entity,httpPost,httpClient,charset);
    }


    /**
     * 请求体请求
     * @param httpClient
     * @param url
     * @param paramHeader
     * @param strJson
     * @param charset
     * @return
     * @throws Exception
     */
    public static String doPostXml(HttpClient httpClient, String url,Map<String, Object> paramHeader, String strJson, String charset) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        //设置请求头
        setHeader(httpPost,paramHeader);
        //设置请求方式
        httpPost.addHeader("Content-Type",ContentType.APPLICATION_XML.getMimeType());
        //参数编码方式和类型
        StringEntity entity = new StringEntity(strJson,ContentType.APPLICATION_XML.getMimeType(),charset);
        return groupRequest(entity,httpPost,httpClient,charset);
    }

    /**
     * 请求聚合
     * @param entity
     * @param httpPost
     * @param httpClient
     * @param charset
     * @return
     * @throws Exception
     */
    private static String groupRequest(StringEntity entity,HttpPost httpPost,HttpClient httpClient,String charset) throws Exception{
        //设置请求信息
        httpPost.setEntity(entity);
        //获取响应
        HttpResponse response = httpClient.execute(httpPost);
        //校验返回码
        validCode(response);
        //获取响应内容
        return getResponse(response,charset);
    }

    /**
     * 请求体请求 put
     * @param httpClient
     * @param paramHeader
     * @param url
     * @param strJson
     * @return
     * @throws Exception
     */
    public static String doPutJson(HttpClient httpClient,String url, Map<String, Object> paramHeader,String strJson) throws Exception {
        return doPutJson(httpClient, url,paramHeader, strJson, DEFAULT_CHARSET);
    }

    /**
     * 请求体请求
     * @param httpClient
     * @param url
     * @param paramHeader
     * @param strJson
     * @param charset
     * @return
     * @throws Exception
     */
    public static String doPutJson(HttpClient httpClient, String url,Map<String, Object> paramHeader, String strJson, String charset) throws Exception {
        HttpPut httpPut = new HttpPut(url);
        //设置请求头
        setHeader(httpPut,paramHeader);
        //设置请求方式
        httpPut.addHeader("Content-Type","application/json");
        StringEntity entity = new StringEntity(strJson);
        //设置请求信息
        httpPut.setEntity(entity);
        //获取响应
        HttpResponse response = httpClient.execute(httpPut);
        //校验返回码
        validCode(response);
        //获取响应内容
        return getResponse(response,charset);
    }

    /**
     * get请求
     * @param httpClient
     * @param url
     * @param paramHeader
     * @param paramBody
     * @return
     * @throws Exception
     */
    public static String doGet(HttpClient httpClient, String url, Map<String, Object> paramHeader,
                               Map<String, Object> paramBody) throws Exception {
        return doGet(httpClient, url, paramHeader, paramBody, DEFAULT_CHARSET);
    }

    /**
     * get请求
     * @param httpClient
     * @param url
     * @param paramHeader
     * @param paramBody
     * @param charset
     * @return
     * @throws Exception
     */
    public static String doGet(HttpClient httpClient, String url, Map<String, Object> paramHeader,
                               Map<String, Object> paramBody, String charset) throws Exception {
        HttpGet httpGet = new HttpGet(spliceParam(url,paramBody));
        //设置请求头
        setHeader(httpGet, paramHeader);
        HttpResponse response = httpClient.execute(httpGet);
        //校验响应码
        validCode(response);
        //获取响应信息
        return getResponse(response,charset);
    }

    /**
     * 拼接get请求参数 对特殊字符进行编码
     * @param url
     * @param requestParam
     * @return
     */
    private static String spliceParam(String url,Map<String,Object> requestParam){
        if(!requestParam.isEmpty()){
            StringBuilder result = new StringBuilder();
            Iterator<Map.Entry<String,Object>> iterator = requestParam.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<String,Object> entry = iterator.next();
                if(StringUtils.isBlank(result.toString())){
                    result.append("?");
                }else{
                    result.append("&");
                }
                result.append(entry.getKey()).append("=").append(entry.getValue());
            }
            url+=result.toString();
        }
        return url;
    }

    /**
     * 获取响应信息
     * @param response
     * @param charset
     * @return
     * @throws Exception
     */
    private static String getResponse(HttpResponse response,String charset) throws Exception{
        if (response != null) {
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                return EntityUtils.toString(resEntity, charset);
            }
        }
        return StringUtils.EMPTY;
    }

    /**
     * 校验http是否请求成功
     * @param response
     */
    private static void validCode(HttpResponse response) throws Exception{
        Optional.ofNullable(response).orElseThrow(()->
                new NoahException(ExceptionType.HTTP_NO_RESPONSE.getCode(),ExceptionType.HTTP_NO_RESPONSE.getName()));
        if(200!=response.getStatusLine().getStatusCode()){
            throw new NoahException(ExceptionType.HTTP_RESPONSE_ERROR.getCode(),
                    ExceptionType.HTTP_RESPONSE_ERROR.getName()+response.getStatusLine().getStatusCode()
                            +" 错误信息为："+ EntityUtils.toString(response.getEntity(),DEFAULT_CHARSET));
        }
    }

    /**
     * 设置请求头
     * @param request
     * @param paramHeader
     */
    private static void setHeader(HttpRequestBase request, Map<String, Object> paramHeader) {
        // 设置Header
        if (paramHeader != null) {
            Set<String> keySet = paramHeader.keySet();
            for (String key : keySet) {
                request.addHeader(key, String.valueOf(paramHeader.get(key)));
            }
        }
        //request.addHeader("cookie","LtpaToken="+LtpaUtil.getLtpaToken("sjzl01"));
    }

    /**
     * 设置请求体
     * @param httpPost
     * @param paramBody
     * @param charset
     * @throws Exception
     */
    private static void setBody(HttpPost httpPost, Map<String, Object> paramBody, String charset) throws Exception {
        // 设置参数
        if (paramBody != null) {
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Set<String> keySet = paramBody.keySet();
            for (String key : keySet) {
                list.add(new BasicNameValuePair(key, String.valueOf(paramBody.get(key))));
            }
            if (list.size() > 0) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
                httpPost.setEntity(entity);
            }
        }
    }
}