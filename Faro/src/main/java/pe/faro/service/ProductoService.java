package pe.faro.service;

import java.util.List;
import java.util.Optional;

import pe.faro.entity.Producto;

public interface ProductoService extends Service<Producto> {
	public List<Producto> buscarPorCategoria(int id);
	public Optional<Producto> FindById(int id);
}
