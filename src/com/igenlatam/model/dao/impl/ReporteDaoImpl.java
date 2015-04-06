package com.igenlatam.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.igenlatam.model.dao.ReporteDao;
import com.igenlatam.model.domain.Auditor;
import com.igenlatam.model.domain.Reporte;

public class ReporteDaoImpl extends org.springframework.orm.hibernate3.support.HibernateDaoSupport implements ReporteDao{

	@Override
	public List<Reporte> listarReportes() {
		return this.getHibernateTemplate().find("from " + Reporte.class.getName());
	}

	@Override
	public void crearReporte(Reporte reporte) {
		this.getHibernateTemplate().save(reporte);
	}

	@Override
	public void editarReporte(Reporte reporte) {
		this.getHibernateTemplate().update(reporte);
	}

	@Override
	public void borrarReporte(Reporte reporte) {
		this.getHibernateTemplate().delete(reporte);
	}

	@Override
	public List<Reporte> buscarReportes(Long reporteId) {
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(Reporte.class);
		
		if(reporteId==0){
			System.out.println("reporte a buscar " + reporteId);
			criteria.add(Restrictions.eq("reporteId", reporteId));	
		}
		
		List<Reporte> reportes = criteria.list();
		//session.close();
		System.out.println("reportes=" + reportes);
		return reportes;
	}
	

}
