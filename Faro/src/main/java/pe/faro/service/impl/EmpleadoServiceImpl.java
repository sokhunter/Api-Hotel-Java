package pe.faro.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.faro.entity.Empleado;
import pe.faro.repository.EmpleadoRepository;
import pe.faro.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	@Autowired
	EmpleadoRepository empleadoRepo;
	
	@Override
	public boolean insert(Empleado obj) {
		boolean flag = false;
		try {
			if(empleadoRepo.save(obj) != null) {
				flag = true;
			}			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public List<Empleado> getall() {
		List<Empleado> empleado=new ArrayList<Empleado>();
		List<Empleado>emp=empleadoRepo.findAll();
		for(Empleado x:emp) {
			if(!x.isEliminado()) {
				empleado.add(x);
			}
		}
		return empleado;
	}

	@Override
	public boolean update(Empleado obj) {
		boolean flag = false;
		try { 
			if(empleadoRepo.save(obj) != null) {
				flag = true;
			}					
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public boolean delete(int id) {
		Optional<Empleado> obj = null;
		Empleado nuevo=new Empleado();
		boolean flag = false;
		try {
			obj=empleadoRepo.findById(id);
			nuevo=obj.get();
			nuevo.setEliminado(true);
			if(empleadoRepo.save(nuevo) != null) {
				flag = true;
			}	
								
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

}
