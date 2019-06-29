package pe.faro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.faro.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	public List<Producto> buscarPorCategoria(int id);
}
