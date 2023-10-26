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




public long count() {
	return libroRepository.count();

}


public Iterable<Libro> findAll (){
	return libroRepository.findAll();
}


public Iterable<Libro> todosLosLibros() {
	
	return libroRepository.findAll();
}






public void deleteById(Long id) {
	
	libroRepository.deleteById(id);
	
}

public Libro  save(Libro libro) {
	return libroRepository.save(libro);
}

	
public void deleteAll() {
	libroRepository.deleteAll();

}


public boolean exitsById(Long id) {
	return libroRepository.existsById(id);

	
}



public Optional<Libro> findById(Long id){
	
	return libroRepository.findById(id);
}


}
