package com.ccty.noah.domain.mapper;

import com.ccty.noah.domain.database.CommentDO;

import java.util.List;

/**
 * @author 缄默
 * @date   2020/06/17
 */
public interface CommentMapper {

    /**
     * 批量插入评价信息
     * @param list
     */
    void insertComments(List<CommentDO> list);
}
