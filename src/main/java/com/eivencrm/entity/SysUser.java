package com.eivencrm.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sys_user database table.
 * 
 */
@Entity
@Table(name="sys_user")
@NamedQuery(name="SysUser.findAll", query="SELECT s FROM SysUser s")
public class SysUser extends com.eivencrm.dao.MkUserDaoImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private int age;
	private int birthday;
	private String email;
	private String mobile;
	private String nickName;
	private String password;
	private String portraitUrl;
	private String realName;
	private int sex;
	private String shuoMing;
	private String skill;
	private String userName;

	public SysUser() {
	}


	@Id
	@SequenceGenerator(name="SYS_USER_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SYS_USER_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	public int getBirthday() {
		return this.birthday;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}


	@Column(length=255)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Column(length=255)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	@Column(length=255)
	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	@Column(length=255)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Column(length=255)
	public String getPortraitUrl() {
		return this.portraitUrl;
	}

	public void setPortraitUrl(String portraitUrl) {
		this.portraitUrl = portraitUrl;
	}


	@Column(length=255)
	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}


	public int getSex() {
		return this.sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}


	@Column(length=255)
	public String getShuoMing() {
		return this.shuoMing;
	}

	public void setShuoMing(String shuoMing) {
		this.shuoMing = shuoMing;
	}


	@Column(length=255)
	public String getSkill() {
		return this.skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}


	@Column(length=255)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}