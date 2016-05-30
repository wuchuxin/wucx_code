package com.mvn_pro.project.base.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import com.mvn_pro.project.base.IBaseManager;
import com.mvn_pro.project.base.IBaseModel;

public class BaseManager<Model extends IBaseModel, PK extends Serializable, Repository extends CrudRepository<Model, PK>>
		implements IBaseManager<Model, PK> {
	
	@Autowired
	private Repository repository;

	public Repository getRepository() {
		return this.repository;
	}

	public Model getById(PK id) {
		return this.repository.findOne(id);
	}

	public Model save(Model model) {
		return this.repository.save(model);
	}

	public Model update(Model model) {
		return this.repository.save(model);
	}

	public void remove(PK id) {
		this.repository.delete(id);
	}

	public List<Model> findAll() {
		List<Model> list = new ArrayList<Model>(0);
		Iterator<Model> iterator = this.repository.findAll().iterator();
		while (iterator.hasNext()) {
			list.add(iterator.next());
		}
		return list;
	}
}
