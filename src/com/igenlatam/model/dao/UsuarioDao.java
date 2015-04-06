package com.igenlatam.model.dao;

import java.util.List;

import com.igenlatam.model.domain.Usuario;

public interface UsuarioDao {
	
	public List<Usuario> listarUsuarios();
	public void crearUsuario(Usuario usuario);
	public void editarUsuario(Usuario usuario);
	public void borrarUsuario(Usuario usuario);
	public List<Usuario> buscarUsuarios(Long usuarioId);


}
