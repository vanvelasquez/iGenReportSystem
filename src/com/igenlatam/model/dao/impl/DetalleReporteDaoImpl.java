package com.igenlatam.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.igenlatam.model.dao.DetalleReporteDao;
import com.igenlatam.model.domain.Auditor;
import com.igenlatam.model.domain.DetalleReporte;

public class DetalleReporteDaoImpl extends org.springframework.orm.hibernate3.support.HibernateDaoSupport implements DetalleReporteDao {

	@Override
	public List<DetalleReporte> listarDetalles() {
		return this.getHibernateTemplate().find("from " + DetalleReporte.class.getName());
	}

	@Override
	public void crearDetalle(DetalleReporte detalle) {
		this.getHibernateTemplate().save(detalle);
	}

	@Override
	public void editarDetalle(DetalleReporte detalle) {
		this.getHibernateTemplate().update(detalle);
	}

	@Override
	public void borrarDetalle(DetalleReporte detalle) {
		this.getHibernateTemplate().delete(detalle);
	}

	@Override
	public List<DetalleReporte> buscarDetalles(Long detalleId) {		
	Session session = this.getSession();
	Criteria criteria = session.createCriteria(DetalleReporte.class);
	
	if(detalleId==0){
		System.out.println("auditor a buscar " + detalleId);
		criteria.add(Restrictions.eq("auditorId", detalleId));	
	}
	
	List<DetalleReporte> detalles = criteria.list();
	//session.close();
	System.out.println("detalles de reporte=" + detalles);
	return detalles;
}	

}
