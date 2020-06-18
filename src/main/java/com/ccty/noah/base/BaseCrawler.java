package com.ccty.noah.base;


import com.ccty.noah.domain.dto.ArticleDTO;

/**
 * 爬虫基类
 * @author 缄默
 * @date   2020/06/09
 */
public abstract class BaseCrawler {

    /**
     * 获取文章信息
     * @param articleDTO 文章基本信息
     * @return 获取文章信息
     */
    public abstract ArticleDTO getArticleInfo(ArticleDTO articleDTO);

}
