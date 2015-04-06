package com.igenlatam.model.dao;

import java.util.List;

import com.igenlatam.model.domain.Auditor;

public interface AuditorDao {
	
	public List<Auditor> listarAuditores();
	public void crearAuditor(Auditor auditor);
	public void editarAuditor(Auditor auditor);
	public void borrarAuditor(Auditor auditor);
	public List<Auditor> buscarAuditores(Long auditorId);

}
