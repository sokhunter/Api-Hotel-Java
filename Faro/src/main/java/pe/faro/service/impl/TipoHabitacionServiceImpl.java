package pe.faro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.faro.entity.TipoHabitacion;
import pe.faro.repository.TipoHabitacionRepository;
import pe.faro.service.TipoHabitacionService;

@Service
public class TipoHabitacionServiceImpl implements TipoHabitacionService {
	@Autowired
	TipoHabitacionRepository tipoHabitacionRepo;
	
	@Override
	public boolean insert(TipoHabitacion obj) {
		boolean flag = false;
		try {
			if(tipoHabitacionRepo.save(obj) != null) {
				flag = true;
			}			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public List<TipoHabitacion> getall() {
		return tipoHabitacionRepo.findAll();
	}

	@Override
	public boolean update(TipoHabitacion obj) {
		boolean flag = false;
		try { 
			if(tipoHabitacionRepo.save(obj) != null) {
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

}
