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

import pe.faro.entity.DetallePedido;
import pe.faro.exception.ModeloNotFoundException;
import pe.faro.service.DetallePedidoService;

@RestController
@RequestMapping(value="/api/detallespedido")
@CrossOrigin
public class DetallePedidoController {
	@Autowired
	DetallePedidoService serviceDetallePedido;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DetallePedido>> listar() {
		try {
			List<DetallePedido> DetallePedidos = serviceDetallePedido.getall();
			
			return new ResponseEntity<List<DetallePedido>>(DetallePedidos, HttpStatus.OK);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			
			return new ResponseEntity<List<DetallePedido>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DetallePedido> insertar(@Valid @RequestBody DetallePedido obj){
		
		try {
			boolean flag = serviceDetallePedido.insert(obj);
			if(flag) {
				return new ResponseEntity<DetallePedido>(HttpStatus.OK);
			}else{
				return new ResponseEntity<DetallePedido>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<DetallePedido>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<DetallePedido> eliminar(@PathVariable int id){
		try {
			boolean flag = serviceDetallePedido.delete(id);
			if(flag){
				return new ResponseEntity<DetallePedido>(HttpStatus.OK);				
			}else {
				return new ResponseEntity<DetallePedido>(HttpStatus.NOT_FOUND);
			}			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<DetallePedido>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping
	public ResponseEntity<DetallePedido> actualizar(@RequestBody DetallePedido obj){
		
		try {
			boolean flag = serviceDetallePedido.update(obj);
			if(flag) {
				return new ResponseEntity<DetallePedido>(HttpStatus.OK);
			}else{
				return new ResponseEntity<DetallePedido>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<DetallePedido>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value="/buscarporpedido/{id}")
	public ResponseEntity<List<DetallePedido>> buscarPorPedido(@PathVariable int id){
		try {
			List<DetallePedido> obj= serviceDetallePedido.buscarPorPedido(id);
			if(obj !=null){
				return new ResponseEntity<List<DetallePedido>>(obj, HttpStatus.OK);				
			}else {
				throw new ModeloNotFoundException("No se encontraron detalles");
			}			
		} catch (Exception e) {
			throw new ModeloNotFoundException("No se encontraron detalles");
		}
	}

}
