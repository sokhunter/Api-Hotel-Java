import { Component, OnInit, Input } from '@angular/core';
import { Pedido } from 'src/app/clases/pedido';
import { ActivatedRoute, Params } from '@angular/router';
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

  constructor(private route: ActivatedRoute,
    private detallePedidoService: DetallePedidoService) { }

  ngOnInit() {
    this.getReserva();
  }
  getReserva(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    console.log(id);//si encuentra el parametro
    this.detallePedidoService.buscarDetalleDePedido(id).subscribe(data => (this.detallePedidos = data));
  }
}
