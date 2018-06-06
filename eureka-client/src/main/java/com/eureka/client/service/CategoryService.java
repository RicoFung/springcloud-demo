package com.eureka.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eureka.client.dao.CategoryDao;
import com.eureka.client.entity.Category;

import chok.devwork.springboot.BaseDao;
import chok.devwork.springboot.BaseService;

@Service
public class CategoryService extends BaseService<Category,Long>
{
	@Autowired
	private CategoryDao dao;

	@Override
	public BaseDao<Category,Long> getEntityDao() 
	{
		return dao;
	}
}
