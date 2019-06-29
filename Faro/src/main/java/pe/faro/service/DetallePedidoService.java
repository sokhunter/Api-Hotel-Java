package pe.faro.service;

import java.util.List;

import pe.faro.entity.DetallePedido;

public interface DetallePedidoService extends Service<DetallePedido> {
	public List<DetallePedido> buscarPorPedido(int id);
}
