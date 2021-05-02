package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.entities.Todo;

@Component
//this tag is important, we use this so we do not need 
//to use bean tag to specify this class to spring 
public class TodoDao {
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public int save(Todo t)
	{
		Integer id = (Integer)this.hibernateTemplate.save(t);
		return id;
	}
	public List<Todo>getAll()
	{
		List<Todo> list = (List<Todo>)this.hibernateTemplate.loadAll(Todo.class);
		return list;
	}
}
