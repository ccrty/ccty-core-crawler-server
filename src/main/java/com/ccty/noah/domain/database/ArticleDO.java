package com.ccty.noah.domain.database;

/**
 * @author 缄默
 * @date   2020/06/16
 */
public class ArticleDO extends BaseDO{

    public ArticleDO() {
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
     * url
     */
    private String url;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
