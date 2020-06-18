package com.ccty.noah.domain.mapper;

import com.ccty.noah.domain.database.ArticleDO;

import java.util.List;

/**
 * @author 缄默
 * @date   2020/06/16
 */
public interface ArticleMapper {

    /**
     * 获取所有的文章
     * @return
     */
    List<ArticleDO> queryArticles();

    /**
     * 批量修改文章信息
     * @param list
     */
    void updateArticles(List<ArticleDO> list);


}
