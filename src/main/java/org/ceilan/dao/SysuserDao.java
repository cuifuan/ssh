package org.ceilan.dao;

import org.ceilan.entity.SysuserEntity;

import java.util.List;

/**
 * Author-Date： cuifuan   2018-06-09 下午 3:49
 * Description：
 */
public interface SysuserDao {
    /**
     * 添加并保存用户
     *
     * @param user
     */
    void add(SysuserEntity user);

    /**
     * 进行登录
     */
    boolean login(SysuserEntity user);


    /**
     * 获取用户列表
     */
    List getUser();

    /**
     * 根据用户Id获取用户信息
     *
     * @param id
     * @return
     */
    SysuserEntity getUser(int id);

    /**
     * 更新用户信息
     *
     * @param user
     */
    void update(SysuserEntity user);


    /**
     * 根据用户id删除用户信息
     *
     * @param id
     */
    void delete(int id);
}
