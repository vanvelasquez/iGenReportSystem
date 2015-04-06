package com.igenlatam.model.dao;

import java.util.List;

import com.igenlatam.model.domain.Proyecto;

public interface ProyectoDao {
	
	public List<Proyecto> listarProyectos();
	public void crearProyecto(Proyecto proyecto);
	public void editarProyecto(Proyecto proyecto);
	public void borrarProyecto(Proyecto proyecto);
	public List<Proyecto> buscarProyectos(Long proyectoId);


}
