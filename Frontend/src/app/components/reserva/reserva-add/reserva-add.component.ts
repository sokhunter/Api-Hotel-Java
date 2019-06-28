import { Component, OnInit } from '@angular/core';
import { ReservaService } from 'src/app/services/reserva.service';
import { Reserva } from 'src/app/clases/reserva';

import { ClienteService } from 'src/app/services/cliente.service';
import { EmpleadoService } from 'src/app/services/empleado.service';
import { HabitacionService } from 'src/app/services/habitacion.service';

import { Cliente } from 'src/app/clases/cliente';
import { Empleado } from 'src/app/clases/empleado';
import { Habitacion } from 'src/app/clases/habitacion';
import { TipoHabitacion } from 'src/app/clases/tipo-habitacion';

@Component({
  selector: 'app-reserva-add',
  templateUrl: './reserva-add.component.html',
  styleUrls: ['./reserva-add.component.css']
})
export class ReservaAddComponent implements OnInit {

	reserva: Reserva = new Reserva();
	clientes: Cliente[];
	empleados: Empleados[];
	tiposhabitacion: TipoHabitacion[];
	habitaciones: Habitacion[];

	constructor(private reservaService: ReservaService, 
		private clienteService: ClienteService,
		private empleadoService: EmpleadoService,
		private habitacionService: HabitacionService

		) { }

	ngOnInit() {
		this.reserva.cliente = new Cliente();
		this.reserva.empleado = new Empleado();
		this.reserva.habitacion = new Habitacion();
		this.reserva.habitacion.tiposhabitacion = new TipoHabitacion();

		this.clienteService.getClientes().subscribe(data => (this.clientes = data));
		this.empleadoService.getEmpleados().subscribe(data => (this.empleados = data));
		this.habitacionService.getHabitaciones().subscribe(data => (this.habitaciones = data));
	}

	reservaAdd(): void {
		console.log(this.reserva);
		this.reservaService.addReserva(this.reserva).subscribe(data => { alert("La reserva se registró correctamente"); });
	}

}
