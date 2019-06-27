package pe.faro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.faro.entity.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{

}
