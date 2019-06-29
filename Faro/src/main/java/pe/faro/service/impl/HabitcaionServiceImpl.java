package pe.faro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.faro.entity.Habitacion;
import pe.faro.repository.HabitacionRepository;
import pe.faro.service.HabitacionService;

@Service
public class HabitcaionServiceImpl implements HabitacionService {
	@Autowired
	HabitacionRepository habitacionRepo;

	@Override
	public boolean insert(Habitacion obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Habitacion> getall() {
		return habitacionRepo.findAll();
	}

	@Override
	public boolean update(Habitacion obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Habitacion> buscarPorTipo(int tipoHabitacionId) {
		return habitacionRepo.buscarPorTipo(tipoHabitacionId);
	}
}
