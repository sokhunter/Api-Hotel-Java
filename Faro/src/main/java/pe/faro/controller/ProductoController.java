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

import pe.faro.entity.Producto;
import pe.faro.service.ProductoService;

@RestController
@RequestMapping(value="/api/productos")
@CrossOrigin
public class ProductoController {
	@Autowired
	ProductoService serviceProducto;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Producto>> listar() {
		try {
			List<Producto> producto = serviceProducto.getall();
			
			return new ResponseEntity<List<Producto>>(producto, HttpStatus.OK);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			
			return new ResponseEntity<List<Producto>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> insertar(@Valid @RequestBody Producto obj){
		
		try {
			boolean flag = serviceProducto.insert(obj);
			if(flag) {
				return new ResponseEntity<Producto>(HttpStatus.OK);
			}else{
				return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<Producto>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping
	public ResponseEntity<Producto> actualizar(@RequestBody Producto obj){
		
		try {
			boolean flag = serviceProducto.update(obj);
			if(flag) {
				return new ResponseEntity<Producto>(HttpStatus.OK);
			}else{
				return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<Producto>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
