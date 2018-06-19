package org.ceilan.service.impl;

import org.ceilan.dao.SysuserDao;
import org.ceilan.entity.SysuserEntity;
import org.ceilan.service.SysuserEntityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author-Date： cuifuan   2018-06-09 下午 4:05
 * Description：
 */
//注入服务
@Service("userService")
public class SysuserServiceImpl implements SysuserEntityService {
    //自动注入userDao，也可以使用@Autowired
    @Resource
    private SysuserDao userDao;
    @Override
    public boolean addSysuserEntity(SysuserEntity user) {
        return false;
    }

    @Override
    public boolean login(SysuserEntity user) {
        return this.userDao.login(user);
    }

    @Override
    public List getAllSysuserEntity() {
        return this.userDao.getUser();
    }

    @Override
    public SysuserEntity getSysuserEntityById(int id) {
        return null;
    }

    @Override
    public boolean updateSysuserEntity(SysuserEntity user) {
        return false;
    }

    @Override
    public boolean deleteSysuserEntity(int id) {
        return false;
    }
}
