

package com.eivencrm.service;

import com.eivencrm.entity.MkUser;

import java.util.List;

public interface MkUserService{
	
	List<MkUser> findAll();
	MkUser getById(String id);
}