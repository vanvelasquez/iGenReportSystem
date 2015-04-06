package com.igenlatam.model.dao.impl;

import java.util.List;

import com.igenlatam.model.dao.RolUsuarioDao;
import com.igenlatam.model.domain.RolUsuario;

public class RolUsuarioDaoImpl extends org.springframework.orm.hibernate3.support.HibernateDaoSupport implements RolUsuarioDao {

	@Override
	public List<RolUsuario> listarRoles() {
		return this.getHibernateTemplate().find("from " + RolUsuario.class.getName());
	}
	

}
