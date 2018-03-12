

package com.eivencrm.service;

import java.util.List;

import com.eivencrm.entity.MkUser;

public interface MkUserService{
	
	List<MkUser> findAll();
	MkUser getById(String id);
}