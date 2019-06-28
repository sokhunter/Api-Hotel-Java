import { Component, OnInit } from '@angular/core';
import { ReservaService } from 'src/app/services/reserva.service';
import { Reserva } from 'src/app/clases/reserva';

@Component({
  selector: 'app-reserva',
  templateUrl: './reserva.component.html',
  styleUrls: ['./reserva.component.css']
})
export class ReservaComponent implements OnInit {

	reservas: Reserva[];

	constructor(private reservaService: ReservaService) { }

	ngOnInit() {
  		this.reservaService.getReservas().subscribe(data => (this.reservas = data));
	}

}
