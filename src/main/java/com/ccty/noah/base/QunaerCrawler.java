package com.ccty.noah.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ccty.noah.aop.aspect.exception.NoahException;
import com.ccty.noah.constants.ExceptionType;
import com.ccty.noah.domain.entity.ArticleE;
import com.ccty.noah.util.http.HTTPSUtil;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

/**
 * 去哪儿网爬取
 * @author 缄默
 * @date   2020/06/09
 */
@Component("QunaerCrawler")
public class QunaerCrawler extends BaseCrawler {

    /**
     * 获取文章信息
     * @return 文章实体
     */
    @Override
    public ArticleE getArticleInfo() {
        //获取文章内容
        String result = HTTPSUtil.doGetByUrl("https://bbs.qyer.com/detail/content/p/20672622%2C20681122%2C20681241%2C20692216%2C20692252%2C20692259%2C20692268%2C20692282%2C20692310%2C20692311%2C20692313%2C20693461%2C20693485%2C20693519%2C20693559.json?ajaxID=5aa7a6618776329315f6d14c&time_sta=1591695033739");
        JSONObject jsonObject = JSON.parseObject(result);
        JSONObject data = jsonObject.getJSONObject("data");
        Optional.ofNullable(data).orElseThrow(()->new NoahException(ExceptionType.GET_QUNAER_ARTICLE_ERROR.getCode(),ExceptionType.GET_QUNAER_ARTICLE_ERROR.getName()));
        Collection<Object> values = data.values();
        //文章对象
        ArticleE article = new ArticleE();
        for(Object detail : values){
            JSONObject paragraph = JSON.parseObject(detail.toString());
            //判断是否是正文 1-正文 0-评论
            if(1==paragraph.getInteger("first")){
                article.setContent(paragraph.getString("content").replace("src","src1"));
                article.setUsername(paragraph.getJSONObject("user").getString("username"));
            }
        }
        article.setArticleSource(CrawlerInterface.ArticleSources.QUNAER.getCode());
        return article;
    }

    public static void main(String[] args) {
        new QunaerCrawler().getArticleInfo();
    }
}
