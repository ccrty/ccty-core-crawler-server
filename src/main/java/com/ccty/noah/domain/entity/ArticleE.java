package com.ccty.noah.domain.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 文章实体类
 * @author 缄默
 * @date   2020/06/09
 */
@AllArgsConstructor
@NoArgsConstructor
public class ArticleE extends BaseEntity {

    public Integer getArticleSource() {
        return articleSource;
    }

    public void setArticleSource(Integer articleSource) {
        this.articleSource = articleSource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 文章来源
     */
    private Integer articleSource;

    /**
     * 标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 用户名
     */
    private String username;

}
