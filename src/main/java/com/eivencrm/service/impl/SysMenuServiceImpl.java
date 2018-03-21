

package com.eivencrm.service.impl;

import com.eivencrm.dao.SysUserDao;
import com.eivencrm.entity.SysMenuEntity;
import com.eivencrm.entity.SysUserEntity;
import com.eivencrm.service.SysMenuService;
import com.eivencrm.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuEntity,Integer> implements SysMenuService {

}