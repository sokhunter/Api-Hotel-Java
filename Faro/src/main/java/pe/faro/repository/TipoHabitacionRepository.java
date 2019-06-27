package pe.faro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.faro.entity.TipoHabitacion;;

@Repository
public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacion, Integer>{

}
