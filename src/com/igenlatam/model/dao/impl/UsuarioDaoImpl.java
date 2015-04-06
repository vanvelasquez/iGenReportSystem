package com.igenlatam.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.igenlatam.model.dao.UsuarioDao;
import com.igenlatam.model.domain.Usuario;

public class UsuarioDaoImpl extends org.springframework.orm.hibernate3.support.HibernateDaoSupport implements UsuarioDao{

	@Override
	public List<Usuario> listarUsuarios() {
		return this.getHibernateTemplate().find("from " + Usuario.class.getName());
	}

	@Override
	public void crearUsuario(Usuario usuario) {
		this.getHibernateTemplate().save(usuario);
	}

	@Override
	public void editarUsuario(Usuario usuario) {
		this.getHibernateTemplate().update(usuario);
	}

	@Override
	public void borrarUsuario(Usuario usuario) {
		this.getHibernateTemplate().delete(usuario);
	}

	@Override
	public List<Usuario> buscarUsuarios(Long usuarioId) {
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(Usuario.class);
		
		if(usuarioId==0){
			System.out.println("usuario a buscar " + usuarioId);
			criteria.add(Restrictions.eq("usuarioId", usuarioId));	
		}
		
		List<Usuario> usuarios = criteria.list();
		//session.close();
		System.out.println("usuarios=" + usuarios);
		return usuarios;
	}

}
