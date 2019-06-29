package pe.faro.service;

import java.util.List;

import pe.faro.entity.Habitacion;

public interface HabitacionService extends Service<Habitacion> {
	public List<Habitacion> buscarPorTipo(int tipoHabitacionId);
}
