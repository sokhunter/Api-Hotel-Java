package pe.faro.service;
import java.util.Optional;
import pe.faro.entity.Reserva;

public interface ReservaService extends Service<Reserva> {
	public Optional<Reserva> buscarPorId(int id);
}
