package com.igenlatam.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.igenlatam.model.dao.AuditorDao;
import com.igenlatam.model.domain.Auditor;

public class AuditorDaoImpl extends org.springframework.orm.hibernate3.support.HibernateDaoSupport implements AuditorDao{

	@Override
	public List<Auditor> listarAuditores() {
		return this.getHibernateTemplate().find("from " + Auditor.class.getName());
	}

	@Override
	public void crearAuditor(Auditor auditor) {
		this.getHibernateTemplate().save(auditor);
		
	}

	@Override
	public void editarAuditor(Auditor auditor) {
		this.getHibernateTemplate().update(auditor);
		
	}

	@Override
	public void borrarAuditor(Auditor auditor) {
		this.getHibernateTemplate().delete(auditor);
		
	}

	@Override
	public List<Auditor> buscarAuditores(Long auditorId) {
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(Auditor.class);
		
		if(auditorId==0){
			System.out.println("auditor a buscar " + auditorId);
			criteria.add(Restrictions.eq("auditorId", auditorId));	
		}
		
		List<Auditor> auditores = criteria.list();
		//session.close();
		System.out.println("auditores=" + auditores);
		return auditores;
	}
	

}
