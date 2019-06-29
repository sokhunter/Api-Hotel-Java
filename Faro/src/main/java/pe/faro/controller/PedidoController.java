package pe.faro.controller;

import java.util.List;
import java.util.Optional;

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

import pe.faro.entity.Pedido;
import pe.faro.exception.ModeloNotFoundException;
import pe.faro.service.PedidoService;

@RestController
@RequestMapping(value="/api/pedidos")
@CrossOrigin
public class PedidoController {
	@Autowired
	PedidoService servicePedido;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pedido>> listar() {
		try {
			List<Pedido> Pedidos = servicePedido.getall();
			
			return new ResponseEntity<List<Pedido>>(Pedidos, HttpStatus.OK);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			
			return new ResponseEntity<List<Pedido>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<Pedido> buscarPorID(@PathVariable int id){
		try {
			Optional<Pedido> obj = servicePedido.FindById(id);
			if(obj.isPresent()){
				return new ResponseEntity<Pedido>(obj.get(), HttpStatus.OK);				
			}else {
				//return new ResponseEntity<Categoria>(HttpStatus.NOT_FOUND);
				throw new ModeloNotFoundException("Categoria no encontrada");
			}			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			//return new ResponseEntity<Categoria>(HttpStatus.INTERNAL_SERVER_ERROR);
			throw new ModeloNotFoundException("Categoria no encontrada");
		}
	}
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> insertar(@Valid @RequestBody Pedido obj){
		
		try {
			boolean flag = servicePedido.insert(obj);
			if(flag) {
				return new ResponseEntity<Pedido>(HttpStatus.OK);
			}else{
				return new ResponseEntity<Pedido>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<Pedido>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Pedido> eliminar(@PathVariable int id){
		try {
			boolean flag = servicePedido.delete(id);
			if(flag){
				return new ResponseEntity<Pedido>(HttpStatus.OK);				
			}else {
				return new ResponseEntity<Pedido>(HttpStatus.NOT_FOUND);
			}			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<Pedido>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping
	public ResponseEntity<Pedido> actualizar(@RequestBody Pedido obj){
		
		try {
			boolean flag = servicePedido.update(obj);
			if(flag) {
				return new ResponseEntity<Pedido>(HttpStatus.OK);
			}else{
				return new ResponseEntity<Pedido>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<Pedido>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
