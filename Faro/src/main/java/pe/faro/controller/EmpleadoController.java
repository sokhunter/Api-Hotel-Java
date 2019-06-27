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

import pe.faro.entity.Empleado;
import pe.faro.service.EmpleadoService;

@RestController
@RequestMapping(value="/api/empleados")
@CrossOrigin
public class EmpleadoController {
	@Autowired
	EmpleadoService serviceEmpleado;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Empleado>> listar() {
		try {
			List<Empleado> empleados = serviceEmpleado.getall();
			
			return new ResponseEntity<List<Empleado>>(empleados, HttpStatus.OK);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			
			return new ResponseEntity<List<Empleado>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Empleado> insertar(@Valid @RequestBody Empleado obj){
		
		try {
			boolean flag = serviceEmpleado.insert(obj);
			if(flag) {
				return new ResponseEntity<Empleado>(HttpStatus.OK);
			}else{
				return new ResponseEntity<Empleado>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<Empleado>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Empleado> eliminar(@PathVariable int id){
		try {
			boolean flag = serviceEmpleado.delete(id);
			if(flag){
				return new ResponseEntity<Empleado>(HttpStatus.OK);				
			}else {
				return new ResponseEntity<Empleado>(HttpStatus.NOT_FOUND);
			}			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<Empleado>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping
	public ResponseEntity<Empleado> actualizar(@RequestBody Empleado obj){
		
		try {
			boolean flag = serviceEmpleado.update(obj);
			if(flag) {
				return new ResponseEntity<Empleado>(HttpStatus.OK);
			}else{
				return new ResponseEntity<Empleado>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<Empleado>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
