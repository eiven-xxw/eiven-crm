

package com.eivencrm.service.impl;

import com.eivencrm.entity.SysMenuEntity;
import com.eivencrm.service.SysMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuEntity,Integer> implements SysMenuService {

}