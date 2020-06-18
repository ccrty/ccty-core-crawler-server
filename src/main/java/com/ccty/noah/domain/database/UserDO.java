package com.ccty.noah.domain.database;

/**
 * @author 缄默
 * @date   2020/06/17
 */
public class UserDO extends BaseDO{

    public UserDO() {
    }

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 头像地址
     */
    private String pictureUrl;

    /**
     * 用户来源
     */
    private Integer userSource;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Integer getUserSource() {
        return userSource;
    }

    public void setUserSource(Integer userSource) {
        this.userSource = userSource;
    }
}
