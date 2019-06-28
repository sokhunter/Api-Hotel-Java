import { Component, OnInit } from '@angular/core';
import { CategoriaService } from 'src/app/services/categoria.service';
import { Categoria } from 'src/app/clases/categoria';

@Component({
  selector: 'app-categoria',
  templateUrl: './categoria.component.html',
  styleUrls: ['./categoria.component.css']
})
export class CategoriaComponent implements OnInit {

	categorias: Categoria[];

	constructor(private categoriaService: CategoriaService) { }

	ngOnInit() {
		this.categoriaService.getCategorias().subscribe(data => (this.categorias = data));
	}

}
