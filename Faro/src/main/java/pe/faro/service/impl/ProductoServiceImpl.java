package pe.faro.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.faro.entity.Producto;
import pe.faro.repository.ProductoRepository;
import pe.faro.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {
	@Autowired
	ProductoRepository productoRepo;
	
	@Override
	public boolean insert(Producto obj) {
		boolean flag = false;
		try {
			if(productoRepo.save(obj) != null) {
				flag = true;
			}			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public List<Producto> getall() {
		return productoRepo.findAll();
	}

	@Override
	public boolean update(Producto obj) {
		boolean flag = false;
		try { 
			if(productoRepo.save(obj) != null) {
				flag = true;
			}					
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Producto> buscarPorCategoria(int id) {
		return productoRepo.buscarPorCategoria(id);
	}

	@Override
	public Optional<Producto> FindById(int id) {
		Optional<Producto> obj= null;
		try {
			obj = productoRepo.findById(id);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return obj;
	}

}
