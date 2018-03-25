package com.eivencrm.dao;

import com.eivencrm.entity.SysUserEntity;

public interface SysUserDao extends BaseDao<SysUserEntity,Integer>{



    public SysUserEntity getUserByLoginName(String loginName);
}
