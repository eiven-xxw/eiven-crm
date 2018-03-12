

package com.eivencrm.dao;

import java.util.List;

import com.eivencrm.entity.MkUser;

public interface MkUserDao{
	
	List<MkUser> findAll();
	MkUser getById(String id);
}