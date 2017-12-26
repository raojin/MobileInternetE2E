/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cust.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.cust.entity.DemoCustomer;
import com.thinkgem.jeesite.modules.cust.service.DemoCustomerService;

/**
 * 客户管理Controller
 * @author 孙真真
 * @version 2017-11-22
 */
@Controller
@RequestMapping(value = "${adminPath}/cust/demoCustomer")
public class DemoCustomerController extends BaseController {

	@Autowired
	private DemoCustomerService demoCustomerService;
	
	@ModelAttribute
	public DemoCustomer get(@RequestParam(required=false) String id) {
		DemoCustomer entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = demoCustomerService.get(id);
		}
		if (entity == null){
			entity = new DemoCustomer();
		}
		return entity;
	}
	
	@RequiresPermissions("cust:demoCustomer:view")
	@RequestMapping(value = {"list", ""})
	public String list(DemoCustomer demoCustomer, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DemoCustomer> page = demoCustomerService.findPage(new Page<DemoCustomer>(request, response), demoCustomer); 
		model.addAttribute("page", page);
		return "modules/cust/demoCustomerList";
	}

	@RequiresPermissions("cust:demoCustomer:view")
	@RequestMapping(value = "form")
	public String form(DemoCustomer demoCustomer, Model model) {
		model.addAttribute("demoCustomer", demoCustomer);
		return "modules/cust/demoCustomerForm";
	}

	@RequiresPermissions("cust:demoCustomer:edit")
	@RequestMapping(value = "save")
	public String save(DemoCustomer demoCustomer, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, demoCustomer)){
			return form(demoCustomer, model);
		}
		demoCustomerService.save(demoCustomer);
		addMessage(redirectAttributes, "保存客户信息成功");
		return "redirect:"+Global.getAdminPath()+"/cust/demoCustomer/?repage";
	}
	
	@RequiresPermissions("cust:demoCustomer:edit")
	@RequestMapping(value = "delete")
	public String delete(DemoCustomer demoCustomer, RedirectAttributes redirectAttributes) {
		demoCustomerService.delete(demoCustomer);
		addMessage(redirectAttributes, "删除客户信息成功");
		return "redirect:"+Global.getAdminPath()+"/cust/demoCustomer/?repage";
	}

}