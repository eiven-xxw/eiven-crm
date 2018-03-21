package com.eivencrm.dao;

import com.eivencrm.entity.SysUserEntity;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.io.Serializable;

public interface SysUserDao extends BaseDao<SysUserEntity,Integer>{



    public SysUserEntity getUserByLoginName(String loginName);
}
