/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cust.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.cust.entity.DemoCustomer;
import com.thinkgem.jeesite.modules.cust.dao.DemoCustomerDao;

/**
 * 客户管理Service
 * @author 孙真真
 * @version 2017-11-22
 */
@Service
@Transactional(readOnly = true)
public class DemoCustomerService extends CrudService<DemoCustomerDao, DemoCustomer> {

	public DemoCustomer get(String id) {
		return super.get(id);
	}
	
	public List<DemoCustomer> findList(DemoCustomer demoCustomer) {
		return super.findList(demoCustomer);
	}
	
	public Page<DemoCustomer> findPage(Page<DemoCustomer> page, DemoCustomer demoCustomer) {
		return super.findPage(page, demoCustomer);
	}
	
	@Transactional(readOnly = false)
	public void save(DemoCustomer demoCustomer) {
		super.save(demoCustomer);
	}
	
	@Transactional(readOnly = false)
	public void delete(DemoCustomer demoCustomer) {
		super.delete(demoCustomer);
	}
	
}