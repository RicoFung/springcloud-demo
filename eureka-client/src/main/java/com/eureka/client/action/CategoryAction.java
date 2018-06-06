package com.eureka.client.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eureka.client.entity.Category;
import com.eureka.client.service.CategoryService;

import chok.devwork.BaseController;

@Scope("prototype")
@Controller
@RequestMapping("/category")
public class CategoryAction extends BaseController<Category>
{
	@Autowired
	private CategoryService service;
	
	@RequestMapping("/query2")
	public void query2()
	{
		Map<String, Object> m = req.getParameterValueMap(false, true);
		result.put("total",service.getCount(m));
		result.put("rows",service.query(req.getDynamicSortParameterValueMap(m)));
		printJson(result.getData());
	}
}