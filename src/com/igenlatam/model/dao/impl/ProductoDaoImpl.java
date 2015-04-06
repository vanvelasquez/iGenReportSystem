package com.igenlatam.model.dao.impl;

import java.util.List;

import com.igenlatam.model.dao.ProductoDao;
import com.igenlatam.model.domain.Producto;

public class ProductoDaoImpl extends org.springframework.orm.hibernate3.support.HibernateDaoSupport implements ProductoDao {

	@Override
	public List<Producto> listarProductos() {
		return this.getHibernateTemplate().find("from " + Producto.class.getName());
	}
	

}
