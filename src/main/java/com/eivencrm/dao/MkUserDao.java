

package com.eivencrm.dao;

import com.eivencrm.entity.MkUser;

import java.util.List;

public interface MkUserDao{
	
	List<MkUser> findAll();
	MkUser getById(String id);
}