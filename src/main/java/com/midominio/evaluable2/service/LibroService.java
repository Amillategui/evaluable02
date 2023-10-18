package com.midominio.evaluable2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.midominio.evaluable2.dao.LibroRepository;
import com.midominio.evaluable2.entity.Libro;

@Service
public class LibroService {
@Autowired
LibroRepository libroRepository;




private long count() {
	return libroRepository.count();

}
	
public void deleteAll() {
	libroRepository.deleteAll();

}

public boolean exitsById(Long id) {
	return libroRepository.existsById(id);

	
}

public Iterable<Libro> findAll (){
	return libroRepository.findAll();
}


public Optional<Libro> findById(Long id){
	
	return libroRepository.findById(id);
}
public void deleteById(Long id) {
	
}
}