import { Component, OnInit } from '@angular/core';
import { ProductoService } from 'src/app/services/producto.service';
import { Producto } from 'src/app/clases/producto';

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styleUrls: ['./producto.component.css']
})
export class ProductoComponent implements OnInit {

	productos: Producto[];

	constructor(private productoService: ProductoService) { }

	ngOnInit() {
		this.productoService.getProductos().subscribe(data => (this.productos = data));
	}

}
