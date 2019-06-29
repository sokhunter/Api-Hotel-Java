package pe.faro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.faro.entity.DetallePedido;
import pe.faro.repository.DetallePedidoRepository;
import pe.faro.service.DetallePedidoService;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {
	@Autowired
	DetallePedidoRepository detallePedidoRepo;
	
	@Override
	public boolean insert(DetallePedido obj) {
		boolean flag = false;
		try {
			if(detallePedidoRepo.save(obj) != null) {
				flag = true;
			}			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public List<DetallePedido> getall() {
		return detallePedidoRepo.findAll();
	}

	@Override
	public boolean update(DetallePedido obj) {
		boolean flag = false;
		try { 
			if(detallePedidoRepo.save(obj) != null) {
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
		try {
			detallePedidoRepo.deleteById(id);
			flag = true;	
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return flag;
	}

	@Override
	public List<DetallePedido> buscarPorPedido(int id) {
		return detallePedidoRepo.buscarPorPedido(id);
	}

}
