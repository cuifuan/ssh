package org.ceilan.service;

import org.ceilan.entity.SysuserEntity;

import java.util.List;

/**
 * Author-Date： cuifuan   2018-06-09 下午 4:02
 * Description：
 */
public interface SysuserEntityService {
    boolean addSysuserEntity(SysuserEntity user);

    boolean login(SysuserEntity user);

    List getAllSysuserEntity();

    SysuserEntity getSysuserEntityById(int id);

    boolean updateSysuserEntity(SysuserEntity user);

    boolean deleteSysuserEntity(int id);
}
