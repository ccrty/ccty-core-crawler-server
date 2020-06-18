package com.ccty.noah.domain.mapper;

import com.ccty.noah.domain.database.UserDO;

import java.util.List;

/**
 * @author 缄默
 * @date   2020/06/17
 */
public interface UserMapper {

    /**
     * 获取所有用户id
     * @return
     */
    List<Integer> findAllUserUid();

    /**
     * 批量插入用户信息
     * @param list
     */
    void insertUsers(List<UserDO> list);
}
