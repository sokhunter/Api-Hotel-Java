package pe.faro.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.faro.entity.Reserva;
import pe.faro.service.ReservaService;

@RestController
@RequestMapping(value="/api/reservas")
@CrossOrigin
public class ReservaController {
	@Autowired
	ReservaService serviceReserva;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Reserva>> listar() {
		try {
			List<Reserva> reservas = serviceReserva.getall();
			
			return new ResponseEntity<List<Reserva>>(reservas, HttpStatus.OK);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			
			return new ResponseEntity<List<Reserva>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Reserva> insertar(@Valid @RequestBody Reserva obj){
		
		try {
			boolean flag = serviceReserva.insert(obj);
			if(flag) {
				return new ResponseEntity<Reserva>(HttpStatus.OK);
			}else{
				return new ResponseEntity<Reserva>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<Reserva>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Reserva> eliminar(@PathVariable int id){
		try {
			boolean flag = serviceReserva.delete(id);
			if(flag){
				return new ResponseEntity<Reserva>(HttpStatus.OK);				
			}else {
				return new ResponseEntity<Reserva>(HttpStatus.NOT_FOUND);
			}			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<Reserva>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping
	public ResponseEntity<Reserva> actualizar(@RequestBody Reserva obj){
		
		try {
			boolean flag = serviceReserva.update(obj);
			if(flag) {
				return new ResponseEntity<Reserva>(HttpStatus.OK);
			}else{
				return new ResponseEntity<Reserva>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<Reserva>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
