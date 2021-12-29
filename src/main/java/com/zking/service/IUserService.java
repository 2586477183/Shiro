package com.zking.service;

import com.zking.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
public interface IUserService {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据用户名获取到用户所有信息
     * @param username
     * @return
     */
    User selectByName(String username);

    /**
     * 根据用户名获取到用户的所有角色
     * @param username
     * @return
     */
    Set<String> getRole(String username);

    /**
     * 根据用户名获得用户所有权限
     * @param username
     * @return
     */
    Set<String> getPermission(String username);
}