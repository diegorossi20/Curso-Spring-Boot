package com.diegorossi.cursospring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegorossi.cursospring.domain.Categoria;
import com.diegorossi.cursospring.repositories.CategoriaRepository;
import com.diegorossi.cursospring.services.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
	}
}
