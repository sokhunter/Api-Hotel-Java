package pe.faro.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.faro.entity.Pedido;
import pe.faro.repository.PedidoRepository;
import pe.faro.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {
	@Autowired
	PedidoRepository pedidoRepo;
	
	@Override
	public boolean insert(Pedido obj) {
		boolean flag = false;
		try {
			if(pedidoRepo.save(obj) != null) {
				flag = true;
			}			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public List<Pedido> getall() {
		/*List<Pedido> pedido=new ArrayList<Pedido>();
		List<Pedido>emp=pedidoRepo.findAll();
		for(Pedido x:emp) {
			if(!x.isCancelado()) {
				pedido.add(x);
			}
		}
		return pedido;*/
		return pedidoRepo.findAll();
	}

	@Override
	public boolean update(Pedido obj) {
		boolean flag = false;
		try { 
			if(pedidoRepo.save(obj) != null) {
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
			pedidoRepo.deleteById(id);
			flag = true;	
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return flag;
		/*Optional<Pedido> obj = null;
		Pedido nuevo=new Pedido();
		boolean flag = false;
		try {
			obj=pedidoRepo.findById(id);
			nuevo=obj.get();
			nuevo.setCancelado(true);
			if(pedidoRepo.save(nuevo) != null) {
				flag = true;
			}							
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return flag;*/
	}

	@Override
	public Optional<Pedido> FindById(int id) {
		Optional<Pedido> obj= null;
		try {
			obj = pedidoRepo.findById(id);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return obj;
	}

}
