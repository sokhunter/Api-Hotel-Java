package pe.faro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.faro.entity.Habitacion;
import pe.faro.service.HabitacionService;

@RestController
@RequestMapping(value="/api/habitaciones")
@CrossOrigin
public class HabitacionController {
	@Autowired
	HabitacionService serviceHabitacion;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Habitacion>> listar() {
		try {
			List<Habitacion> habitaciones = serviceHabitacion.getall();
			
			return new ResponseEntity<List<Habitacion>>(habitaciones, HttpStatus.OK);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			
			return new ResponseEntity<List<Habitacion>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
