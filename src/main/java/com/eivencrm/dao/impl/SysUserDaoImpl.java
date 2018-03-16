package com.eivencrm.dao.impl;

import com.eivencrm.dao.SysUserDao;
import com.eivencrm.entity.SysUserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class SysUserDaoImpl extends BaseDaoImpl implements SysUserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public SysUserEntity getUserByLoginName(String loginName) {
        String sql="select * from sys_user u  WHERE u.login_name='"+loginName+"'";
        System.out.println(sql+"--------sql语句-------------");
        Query query=entityManager.createNativeQuery(sql);
        List<Object[]> list= query.getResultList();
        entityManager.close();
        if(list!=null){
            Object[] obj = list.get(0);
            int index =0;
            SysUserEntity sysUserEntity =  new SysUserEntity();
            sysUserEntity.setId((int)obj[index]);index++;
            if(obj[index]!=null)sysUserEntity.setCompanyId((Integer)obj[index]);index++;
            if(obj[index]!=null)sysUserEntity.setOfficeId((Integer)obj[index]);index++;
            if(obj[index]!=null)sysUserEntity.setLoginName((String)obj[index]);index++;
            if(obj[index]!=null)sysUserEntity.setPassword((String)obj[index]);index++;
            if(obj[index]!=null)sysUserEntity.setNo((String)obj[index]);index++;
            if(obj[index]!=null)sysUserEntity.setName((String)obj[index]);index++;
            if(obj[index]!=null)sysUserEntity.setEmail((String)obj[index]);index++;
            if(obj[index]!=null)sysUserEntity.setPhone((String)obj[index]);index++;
            if(obj[index]!=null)sysUserEntity.setUserType((String)obj[index]);index++;
            if(obj[index]!=null)sysUserEntity.setMobile((String)obj[index]);index++;
            if(obj[index]!=null)sysUserEntity.setPhoto((String)obj[index]);index++;
            if(obj[index]!=null)sysUserEntity.setLoginIp((String)obj[index]);index++;
            if(obj[index]!=null)sysUserEntity.setLoginTime(Timestamp.valueOf(obj[index].toString()));index++;
            if(obj[index]!=null)sysUserEntity.setLoginFlag((String)obj[index]);index++;
            if(obj[index]!=null)sysUserEntity.setCreateId((Integer)obj[index]);index++;
            if(obj[index]!=null)sysUserEntity.setCreateTime(Timestamp.valueOf(obj[index].toString()));index++;
            if(obj[index]!=null)sysUserEntity.setUpdateId((Integer)obj[index]);index++;
            if(obj[index]!=null)sysUserEntity.setUpdateTime(Timestamp.valueOf(obj[index].toString()));index++;
            if(obj[index]!=null)sysUserEntity.setRemarks((String)obj[index]);index++;
            if(obj[index]!=null)sysUserEntity.setDelFlag((Integer)obj[index]);index++;
            if(obj[index]!=null)sysUserEntity.setIsUse((Integer)obj[index]);index++;
            return sysUserEntity;
        }else{
            return null;
        }
    }


}
