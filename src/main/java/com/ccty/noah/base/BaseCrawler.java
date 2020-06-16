package com.ccty.noah.base;

import com.ccty.noah.domain.entity.ArticleE;

/**
 * 爬虫基类
 * @author 缄默
 * @date   2020/06/09
 */
public abstract class BaseCrawler {

    /**
     * 获取文章信息
     * @return 获取文章信息
     */
    public abstract ArticleE getArticleInfo();

}
