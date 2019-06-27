package pe.faro.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.faro.entity.Cliente;
import pe.faro.repository.ClienteRepository;
import pe.faro.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	@Autowired
	ClienteRepository clienteRepo;
	
	@Override
	public boolean insert(Cliente obj) {
		boolean flag = false;
		try {
			if(clienteRepo.save(obj) != null) {
				flag = true;
			}			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public List<Cliente> getall() {
		return clienteRepo.findAll();
	}

	@Override
	public boolean update(Cliente obj) {
		boolean flag = false;
		try { 
			if(clienteRepo.save(obj) != null) {
				flag = true;
			}					
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public boolean delete(int id) {
		/*
		Optional<Cliente> obj = null;
		Cliente nuevo=new Cliente();
		boolean flag = false;
		try {
			obj=clienteRepo.findById(id);
			nuevo=obj.get();
			nuevo.setEliminado(true);
			if(clienteRepo.save(nuevo) != null) {
				flag = true;
			}	
								
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
		*/
		return false;
	}

}
