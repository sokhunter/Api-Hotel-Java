import { Component, OnInit } from '@angular/core';
import { Pedido } from 'src/app/clases/pedido';
import { Reserva } from 'src/app/clases/reserva';
import { PedidoService } from 'src/app/services/pedido.service';
import { ReservaService } from 'src/app/services/reserva.service';

@Component({
  selector: 'app-pedido-add',
  templateUrl: './pedido-add.component.html',
  styleUrls: ['./pedido-add.component.css']
})
export class PedidoAddComponent implements OnInit {
  pedido: Pedido = new Pedido();
  reservas: Reserva[];

  constructor(private pedidoService: PedidoService, private reservaService: ReservaService) { }

  ngOnInit() {
    this.pedido.reserva = new Reserva();

    this.reservaService.getReservas().subscribe(data => (this.reservas = data));
  }
  pedidoAdd(): void {
    this.pedidoService.addPedido(this.pedido).subscribe(data => { alert("El pedido se registró correctamente"); });
  }
}
