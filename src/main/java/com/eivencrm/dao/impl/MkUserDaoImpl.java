

package com.eivencrm.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.eivencrm.dao.MkUserDao;
import org.springframework.stereotype.Repository;

import com.eivencrm.entity.MkUser;
@Repository
public class MkUserDaoImpl implements MkUserDao {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public List<MkUser> findAll() {
		return null;
	}

	@Override
	public MkUser getById(String id) {
		 return this.entityManager.find(MkUser.class,id);
	}
	
}