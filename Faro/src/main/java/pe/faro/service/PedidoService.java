package pe.faro.service;

import java.util.Optional;

import pe.faro.entity.Pedido;

public interface PedidoService extends Service<Pedido> {
	public Optional<Pedido> FindById(int id);

}
