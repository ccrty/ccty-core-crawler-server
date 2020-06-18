package com.ccty.noah.domain.dto;

import java.util.List;

/**
 * 文章实体
 * @author 缄默
 * @date   2020/06/16
 */
public class ArticleDTO {

    public ArticleDTO() {
    }

    /**
     * id
     */
    private Integer id;

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
     * 用户id
     */
    private Integer creator;

    /**
     * url
     */
    private String url;

    /**
     * 评价
     */
    private List<CommentDTO> commentDTOS;

    /**
     * 用户
     */
    private List<UserDTO> userDTOS;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<CommentDTO> getCommentDTOS() {
        return commentDTOS;
    }

    public void setCommentDTOS(List<CommentDTO> commentDTOS) {
        this.commentDTOS = commentDTOS;
    }

    public List<UserDTO> getUserDTOS() {
        return userDTOS;
    }

    public void setUserDTOS(List<UserDTO> userDTOS) {
        this.userDTOS = userDTOS;
    }
}
