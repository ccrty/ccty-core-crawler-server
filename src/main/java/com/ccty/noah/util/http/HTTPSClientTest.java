package com.ccty.noah.util.http;



import org.apache.http.client.HttpClient;

import java.util.HashMap;

public class HTTPSClientTest {

    public static void main(String[] args) throws Exception {
        HttpClient httpClient = new HTTPSTrustClient().init();

        String url = "https://bbs.qyer.com/detail/content/p/20709268%2C20714776%2C20714802%2C20715453%2C20716187%2C20719652%2C20719999.json?ajaxID=5aa7a6618776329315f6d14c&time_sta=1591607780827";


        String result = HTTPSClientUtil.doGet(httpClient, url, new HashMap<>(),new HashMap<>());

        System.out.println(result);
    }

}