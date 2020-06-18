package com.ccty.noah.domain.dto;

/**
 * 评价实体
 * @author 缄默
 * @date   2020/06/16
 */
public class CommentDTO {

    /**
     * id
     */
    private Integer id;

    /**
     * 创建人
     */
    private Integer creator;

    /**
     * 文章id
     */
    private Integer aid;

    /**
     * 评价内容
     */
    private String content;

    /**
     * 评价来源
     */
    private Integer commentSource;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCommentSource() {
        return commentSource;
    }

    public void setCommentSource(Integer commentSource) {
        this.commentSource = commentSource;
    }
}
