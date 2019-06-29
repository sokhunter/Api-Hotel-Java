import { Component, OnInit } from '@angular/core';
import { Pedido } from 'src/app/clases/pedido';
import { Reserva } from 'src/app/clases/reserva';
import { PedidoService } from 'src/app/services/pedido.service';
import { ReservaService } from 'src/app/services/reserva.service';
import { DetallePedido } from 'src/app/clases/detalle-pedido';
import { DetallePedidoService } from 'src/app/services/detalle-pedido.service';
import { Categoria } from 'src/app/clases/categoria';
import { Producto } from 'src/app/clases/producto';
import { CategoriaService } from 'src/app/services/categoria.service';
import { ProductoService } from 'src/app/services/producto.service';

@Component({
  selector: 'app-pedido-add',
  templateUrl: './pedido-add.component.html',
  styleUrls: ['./pedido-add.component.css']
})
export class PedidoAddComponent implements OnInit {
  pedido: Pedido = new Pedido();
  reservas: Reserva[];
  detalles: DetallePedido[];
  categorias: Categoria[];
  productos: Producto[];
  categoria: number;
  detalle: DetallePedido;
  productoID: number;
  producto: Producto;

  constructor(private pedidoService: PedidoService, 
    private reservaService: ReservaService,
    private detalleService: DetallePedidoService,
    private categoriaService: CategoriaService,
    private productoService: ProductoService) { }

  ngOnInit() {
    this.pedido.reserva = new Reserva();
    this.reservaService.getReservas().subscribe(data => (this.reservas = data));
    this.categoriaService.getCategorias().subscribe(data => (this.categorias = data));
    this.productoService.getProductos().subscribe(data => (this.productos = data));
    this.detalles = new Array();
  }

  pedidoAdd(): void {
    this.pedidoService.addPedido(this.pedido).subscribe(data => { alert("El pedido se registró correctamente"); });
  }

	filtrarProductos(): void {
		// this.productoService.buscarPorCategoria(this.categoria).subscribe(data => (this.productos = data));
  }
  detalleAdd(): void {
    // this.productoService.buscarPorID(this.productoID).subscribe(data => (this.producto = data));
    this.detalle = new DetallePedido();
    this.detalle.producto = this.producto;
    // this.detalle.precio = this.producto.precio;
    this.detalle.cantidad = 1;
    this.detalles.push(this.detalle);
    console.log(this.detalles);
  }
  detalleDelete(id): void {
    //CORREGIR
    // this.detalles.find(function(element) {element.producto.id == id});
    // this.detalles.splice(1, 1);
  }
}
