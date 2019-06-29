import { Component, OnInit, Input } from '@angular/core';
import { Pedido } from 'src/app/clases/pedido';
import { ActivatedRoute } from '@angular/router';
import { DetallePedidoService } from 'src/app/services/detalle-pedido.service';
import { DetallePedido } from 'src/app/clases/detalle-pedido';

@Component({
  selector: 'app-detalle-pedido',
  templateUrl: './detalle-pedido.component.html',
  styleUrls: ['./detalle-pedido.component.css']
})
export class DetallePedidoComponent implements OnInit {
  @Input() pedido: Pedido;
  detallePedidos: DetallePedido[];

  pedidoId: number;

  constructor(private route: ActivatedRoute,
    private detallePedidoService: DetallePedidoService) { }

  ngOnInit() {
    console.log(this.pedido);
    this.pedidoId = this.pedido.id;
    console.log(this.pedidoId);
    console.log(this.pedido);
    this.getDetallesPedido();
  }
  getDetallesPedido() {
    this.detallePedidoService.buscarDetalleDePedido(this.pedidoId).subscribe(data => (this.detallePedidos = data));
  }
}
