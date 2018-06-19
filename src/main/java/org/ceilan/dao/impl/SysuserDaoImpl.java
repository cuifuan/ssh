package org.ceilan.dao.impl;

import org.ceilan.dao.SysuserDao;
import org.ceilan.entity.SysuserEntity;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

/**
 * Author-Date： cuifuan   2018-06-09 下午 3:51
 * Description：
 */
@Transactional(rollbackFor = Exception.class)
//出现Exception异常回滚
@Repository("sysuserDao") //进行注入
public class SysuserDaoImpl implements SysuserDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public SysuserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * 添加并保存用户
     *
     * @param user
     */
    @Override
    public void add(SysuserEntity user) {
        sessionFactory.getCurrentSession().save(user);
    }

    /**
     * 进行登录
     *
     * @param user
     */
    @Override
    public boolean login(SysuserEntity user) {
        Iterator<SysuserEntity> it;
        //这里的from后跟的是类名而不是表名
        String hsql="FROM SysuserEntity u where u.username=? and u.password=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hsql);
        query.setString(0, user.getUsername());
        query.setString(1, user.getPassword());
        it=query.iterate();
        return it.hasNext();
    }

    /**
     * 获取用户列表
     */
    @Override
    public List getUser() {
        String hql="FROM SysuserEntity u";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return (List<SysuserEntity>) query.list();
    }

    /**
     * 根据用户Id获取用户信息
     *
     * @param id
     * @return
     */
    @Override
    public SysuserEntity getUser(int id) {
        String hsql="FROM SysuserEntity u where u.id=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hsql);
        query.setString(0, String.valueOf(id));
        return query.list().size()>0?(SysuserEntity) query.list().get(0):null;
    }

    /**
     * 更新用户信息
     *
     * @param user
     */
    @Override
    public void update(SysuserEntity user) {
        sessionFactory.getCurrentSession().update(user);
    }

    /**
     * 根据用户id删除用户信息
     *
     * @param id
     */
    @Override
    public void delete(int id) {
        SysuserEntity user = new SysuserEntity();
        user.setId(id);
        sessionFactory.getCurrentSession().delete(user);
    }
}
