package pe.faro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.faro.entity.Categoria;
import pe.faro.repository.CategoriaRepository;
import pe.faro.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	@Autowired
	CategoriaRepository categoriaRepo;
	
	@Override
	public boolean insert(Categoria obj) {
		boolean flag = false;
		try {
			if(categoriaRepo.save(obj) != null) {
				flag = true;
			}			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public List<Categoria> getall() {
		return categoriaRepo.findAll();
	}

	@Override
	public boolean update(Categoria obj) {
		boolean flag = false;
		try { 
			if(categoriaRepo.save(obj) != null) {
				flag = true;
			}					
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public boolean delete(int id) {
		boolean flag = false;
		/*
		try {
			if(id>1) { 
				categoriaRepo.deleteById(id);
				flag = true;
			}else {
				flag = false;
			}			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		*/
		return flag;
	}

}
