package com.eivencrm.service.impl;

import com.eivencrm.dao.BaseDao;
import com.eivencrm.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service("baseServiceImpl")
public abstract class BaseServiceImpl<T,ID extends Serializable> implements BaseService<T,ID> {


    @Autowired
    private BaseDao<T,ID> baseDao;

    @Override
    public List<T> findAll(String tablename) {
        return baseDao.findAll(tablename);
    }

    @Override
    public boolean save(T entity) {
        return baseDao.save(entity);
    }

    @Override
    public T findByid(T t, ID id) {
        return baseDao.findByid(t,id);
    }

    @Override
    public List<T> findByHql(String tablename, String filed, Object o) {
        return baseDao.findByHql(tablename,filed,o);
    }

    @Override
    public Object findObjiectByHql(String tablename, String filed, Object o) {
        return baseDao.findObjiectByHql(tablename,filed,o);
    }

    @Override
    public List<T> findByMoreFiled(String tablename, LinkedHashMap<String, Object> map) {
        return baseDao.findByMoreFiled(tablename,map);
    }

    @Override
    public List<T> findByMoreFiledPages(String tablename, LinkedHashMap<String,List<Map<String,Object>>> map, int start, int pageNumer) {
        return baseDao.findByMoreFiledPages(tablename,map,start,pageNumer);
    }

    @Override
    public List<T> findPages(String tablename, String filed, Object o, int start, int pageNumer) {
        return baseDao.findPages(tablename,filed,o,start,pageNumer);
    }

    @Override
    public boolean delete(T entity) {
        return baseDao.delete(entity);
    }

    @Override
    public boolean update(T e) {
        return baseDao.update(e);
    }

    @Override
    public Integer updateMoreFiled(String tablename, LinkedHashMap<String, Object> map) {
        return baseDao.updateMoreFiled(tablename,map);
    }

    @Override
    public Object findCount(String tablename, LinkedHashMap<String,List<Map<String,Object>>> map) {
        return baseDao.findCount(tablename,map);
    }
}
