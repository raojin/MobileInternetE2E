/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cust.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.cust.entity.DemoCustomer;

/**
 * 客户管理DAO接口
 * @author 孙真真
 * @version 2017-11-22
 */
@MyBatisDao
public interface DemoCustomerDao extends CrudDao<DemoCustomer> {
	
}