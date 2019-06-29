package pe.faro.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.faro.entity.Reserva;
import pe.faro.repository.ReservaRepository;
import pe.faro.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService {
	@Autowired
	ReservaRepository reservaRepo;
	
	@Override
	public boolean insert(Reserva obj) {
		boolean flag = false;
		Date fecha = new Date();
		try {
			obj.setFregistro(fecha);
			if(obj.getFfin().compareTo(obj.getFinicio()) >= 0) {
				if(reservaRepo.save(obj) != null) {
					flag = true;
				}
			}	
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public List<Reserva> getall() {
		List<Reserva> reserva=new ArrayList<Reserva>();
		List<Reserva>emp=reservaRepo.findAll();
		for(Reserva x:emp) {
			if(!x.isAnulado()) {
				reserva.add(x);
			}
		}
		return reserva;
	}

	@Override
	public boolean update(Reserva obj) {
		boolean flag = false;
		Reserva reserva = new Reserva();
		try {
			reserva = reservaRepo.findById(obj.getId()).get();
			obj.setFregistro(reserva.getFregistro());
			if(obj.getFfin().compareTo(obj.getFinicio()) >= 0) {
				if(reservaRepo.save(obj) != null) {
					flag = true;
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public boolean delete(int id) {
		Reserva reserva = new Reserva();
		boolean flag = false;
		Date fecha = new Date();
		try {
			reserva = reservaRepo.findById(id).get();
			reserva.setAnulado(true);
			if(((reserva.getFinicio().getTime() - fecha.getTime()) / 86400000) >= 5) {
				if(reservaRepo.save(reserva) != null) {
					flag = true;
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public Optional<Reserva> buscarPorId(int id) {
		Optional<Reserva> objReserva = null;
		try {
			objReserva = reservaRepo.findById(id);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return objReserva;
	}

}
