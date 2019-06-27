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

import pe.faro.entity.Categoria;
import pe.faro.service.CategoriaService;

@RestController
@RequestMapping(value="/api/categorias")
@CrossOrigin
public class CategoriaController {
	@Autowired
	CategoriaService serviceCategoria;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Categoria>> listar() {
		try {
			List<Categoria> categorias = serviceCategoria.getall();
			
			return new ResponseEntity<List<Categoria>>(categorias, HttpStatus.OK);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			
			return new ResponseEntity<List<Categoria>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Categoria> insertar(@Valid @RequestBody Categoria obj){
		
		try {
			boolean flag = serviceCategoria.insert(obj);
			if(flag) {
				return new ResponseEntity<Categoria>(HttpStatus.OK);
			}else{
				return new ResponseEntity<Categoria>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<Categoria>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Categoria> eliminar(@PathVariable int id){
		try {
			boolean flag = serviceCategoria.delete(id);
			if(flag){
				return new ResponseEntity<Categoria>(HttpStatus.OK);				
			}else {
				return new ResponseEntity<Categoria>(HttpStatus.NOT_FOUND);
			}			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<Categoria>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping
	public ResponseEntity<Categoria> actualizar(@RequestBody Categoria obj){
		
		try {
			boolean flag = serviceCategoria.update(obj);
			if(flag) {
				return new ResponseEntity<Categoria>(HttpStatus.OK);
			}else{
				return new ResponseEntity<Categoria>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<Categoria>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
