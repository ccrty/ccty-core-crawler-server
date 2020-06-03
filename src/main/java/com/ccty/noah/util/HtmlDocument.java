package com.ccty.noah.util;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.Map;

/**
 * 解析html节点信息
 * @author 缄默
 * @date 2019/5/17
 */
@Slf4j
public class HtmlDocument {

    /**
     * 获取节点信息
     * @param htmlStr
     * @return
     */
    public static List<Map<String,Object>> getDocumentInfo(String htmlStr){
        Document doc = Jsoup.parse(htmlStr);
        Elements dls = doc.getElementsByTag("a");
        return null;
    }
}
