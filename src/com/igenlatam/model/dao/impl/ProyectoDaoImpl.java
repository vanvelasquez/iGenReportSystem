package com.igenlatam.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.igenlatam.model.dao.ProyectoDao;
import com.igenlatam.model.domain.Auditor;
import com.igenlatam.model.domain.Proyecto;

public class ProyectoDaoImpl extends org.springframework.orm.hibernate3.support.HibernateDaoSupport implements ProyectoDao {

	@Override
	public List<Proyecto> listarProyectos() {
		return this.getHibernateTemplate().find("from " + Proyecto.class.getName());
	}

	@Override
	public void crearProyecto(Proyecto proyecto) {
		this.getHibernateTemplate().save(proyecto);
	}

	@Override
	public void editarProyecto(Proyecto proyecto) {
		this.getHibernateTemplate().update(proyecto);
	}

	@Override
	public void borrarProyecto(Proyecto proyecto) {
		this.getHibernateTemplate().delete(proyecto);
	}

	@Override
	public List<Proyecto> buscarProyectos(Long proyectoId) {
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(Proyecto.class);
		
		if(proyectoId==0){
			System.out.println("proyecto a buscar " + proyectoId);
			criteria.add(Restrictions.eq("proyectoId", proyectoId));	
		}
		
		List<Proyecto> proyectos = criteria.list();
		//session.close();
		System.out.println("proyectos=" + proyectos);
		return proyectos;
	}

}
