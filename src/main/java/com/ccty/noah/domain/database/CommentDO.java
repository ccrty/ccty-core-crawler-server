package com.ccty.noah.domain.database;

/**
 * @author 缄默
 * @date   2020/06/17
 */
public class CommentDO extends BaseDO{

    public CommentDO() {
    }

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
