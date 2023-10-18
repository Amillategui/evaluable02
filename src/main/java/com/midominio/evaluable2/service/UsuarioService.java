package com.midominio.evaluable2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midominio.evaluable2.dao.UsuarioRepository;

import com.midominio.evaluable2.entity.Usuario;


@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	private long count() {
	return usuarioRepository.count();
}
	
	public void deleteAll() {
		usuarioRepository.deleteAll();
	
}
	
	public boolean exitsById(Long id) {
		return usuarioRepository.existsById(id);

}

	public Iterable<Usuario> findAll (){
		return usuarioRepository.findAll();
	}

	public Optional<Usuario> findById(Long id){
		
		return usuarioRepository.findById(id);
	}
	public void deleteById(Long id) {
		
	}
	
	
	
}