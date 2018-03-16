

package com.eivencrm.service;

import com.eivencrm.entity.SysUserEntity;

public interface SysUserService extends  BaseService{
	public SysUserEntity getUserByLoginName(String loginName);
}