package com.eivencrm.dao;

import com.eivencrm.entity.SysUserEntity;

public interface SysUserDao extends BaseDao{



    public SysUserEntity getUserByLoginName(String loginName);
}
