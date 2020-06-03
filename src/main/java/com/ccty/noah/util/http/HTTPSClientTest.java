package com.ccty.noah.util.http;



import org.apache.http.client.HttpClient;

import java.util.HashMap;

public class HTTPSClientTest {

    public static void main(String[] args) throws Exception {
        HttpClient httpClient = null;

        httpClient = new HTTPSTrustClient().init();

        String url = "https://igc-es.wucb.com/ibm/iis/dq/da/rest/v1/workspaces/overview";


        String result = HTTPSClientUtil.doGet(httpClient, url, new HashMap<>(),new HashMap<>());

        System.out.println(result);
    }

}