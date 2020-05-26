package com.jianmo.crawler.util;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 获取网页内容
 * @author 缄默
 * @date 2019/5/17
 */
public class PageHtml {

    /**
     * 获取网页内容
     * @param currentUrl
     * @return
     */
    public static String getPageHtml(String currentUrl) {
        HttpClient httpClient=new DefaultHttpClient();
        httpClient = HttpsClient.getNewHttpsClient(httpClient);
        String html = "";
        HttpGet request = new HttpGet(currentUrl);
        HttpResponse response = null;
        try {
            response = httpClient.execute(request);
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                HttpEntity mEntity = response.getEntity();
                html = EntityUtils.toString(mEntity);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return html;
    }

    public static void main(String[] args) {
        System.out.println(PageHtml.getPageHtml("https://www.mafengwo.cn/"));
    }
}
