/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cust.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 客户管理Entity
 * @author 孙真真
 * @version 2017-11-22
 */
public class DemoCustomer extends DataEntity<DemoCustomer> {
	
	private static final long serialVersionUID = 1L;
	private String custname;		// 客户名称
	private String custcode;		// 客户编号
	private String sex;		// 性别
	private String phone;		// 客户电话
	
	public DemoCustomer() {
		super();
	}

	public DemoCustomer(String id){
		super(id);
	}

	@Length(min=0, max=200, message="客户名称长度必须介于 0 和 200 之间")
	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}
	
	@Length(min=0, max=64, message="客户编号长度必须介于 0 和 64 之间")
	public String getCustcode() {
		return custcode;
	}

	public void setCustcode(String custcode) {
		this.custcode = custcode;
	}
	
	@Length(min=0, max=1, message="性别长度必须介于 0 和 1 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Length(min=0, max=32, message="客户电话长度必须介于 0 和 32 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}