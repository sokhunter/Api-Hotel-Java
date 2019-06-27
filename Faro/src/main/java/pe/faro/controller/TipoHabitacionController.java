package pe.faro.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.faro.entity.TipoHabitacion;
import pe.faro.service.TipoHabitacionService;

@RestController
@RequestMapping(value="/api/tiposhabitacion")
@CrossOrigin
public class TipoHabitacionController {
	@Autowired
	TipoHabitacionService serviceTipoHabitacion;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoHabitacion>> listar() {
		try {
			List<TipoHabitacion> tiposHabitacion = serviceTipoHabitacion.getall();
			
			return new ResponseEntity<List<TipoHabitacion>>(tiposHabitacion, HttpStatus.OK);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			
			return new ResponseEntity<List<TipoHabitacion>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoHabitacion> insertar(@Valid @RequestBody TipoHabitacion obj){
		
		try {
			boolean flag = serviceTipoHabitacion.insert(obj);
			if(flag) {
				return new ResponseEntity<TipoHabitacion>(HttpStatus.OK);
			}else{
				return new ResponseEntity<TipoHabitacion>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<TipoHabitacion>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping
	public ResponseEntity<TipoHabitacion> actualizar(@RequestBody TipoHabitacion obj){
		
		try {
			boolean flag = serviceTipoHabitacion.update(obj);
			if(flag) {
				return new ResponseEntity<TipoHabitacion>(HttpStatus.OK);
			}else{
				return new ResponseEntity<TipoHabitacion>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<TipoHabitacion>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
