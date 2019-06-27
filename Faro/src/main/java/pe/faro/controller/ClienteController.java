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

import pe.faro.entity.Cliente;
import pe.faro.service.ClienteService;

@RestController
@RequestMapping(value="/api/clientes")
@CrossOrigin
public class ClienteController {
	@Autowired
	ClienteService serviceCliente;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> listar() {
		try {
			List<Cliente> clientes = serviceCliente.getall();
			
			return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			
			return new ResponseEntity<List<Cliente>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> insertar(@Valid @RequestBody Cliente obj){
		
		try {
			boolean flag = serviceCliente.insert(obj);
			if(flag) {
				return new ResponseEntity<Cliente>(HttpStatus.OK);
			}else{
				return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Cliente> eliminar(@PathVariable int id){
		try {
			boolean flag = serviceCliente.delete(id);
			if(flag){
				return new ResponseEntity<Cliente>(HttpStatus.OK);				
			}else {
				return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
			}			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping
	public ResponseEntity<Cliente> actualizar(@RequestBody Cliente obj){
		
		try {
			boolean flag = serviceCliente.update(obj);
			if(flag) {
				return new ResponseEntity<Cliente>(HttpStatus.OK);
			}else{
				return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
