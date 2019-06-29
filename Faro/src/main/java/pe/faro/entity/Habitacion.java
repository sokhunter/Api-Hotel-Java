package pe.faro.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Table(name="habitaciones")
@NamedQueries({
	@NamedQuery(
			name="Habitacion.buscarPorTipo", 
			query="select c from Habitacion c where c.tiposhabitacion.id = ?1"
	)
})

public class Habitacion implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="tiposhabitacion_id")
	private TipoHabitacion tiposhabitacion;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoHabitacion getTiposhabitacion() {
		return tiposhabitacion;
	}

	public void setTiposhabitacion(TipoHabitacion tiposhabitacion) {
		this.tiposhabitacion = tiposhabitacion;
	}
	
}
