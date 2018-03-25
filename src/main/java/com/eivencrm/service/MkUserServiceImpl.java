

package com.eivencrm.service;

import java.util.List;

import com.eivencrm.entity.MkUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eivencrm.dao.MkUserDao;

@Service
@Transactional
public class MkUserServiceImpl implements MkUserService{

	@Autowired
	private MkUserDao mkuserdao;
	
	
	@Override
	public List<MkUser> findAll() {
		
		
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public MkUser getById(String id) {
		return mkuserdao.getById(id);
	}
}