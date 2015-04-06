package com.igenlatam.model.dao.impl;

import java.util.List;

import com.igenlatam.model.dao.ZonaDao;
import com.igenlatam.model.domain.Zona;

public class ZonaDaoImpl extends org.springframework.orm.hibernate3.support.HibernateDaoSupport implements ZonaDao{

	@Override
	public List<Zona> listarZonas() {
		return this.getHibernateTemplate().find("from " + Zona.class.getName());
	}

}
