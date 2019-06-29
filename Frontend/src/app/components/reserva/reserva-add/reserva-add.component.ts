import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { ReservaService } from 'src/app/services/reserva.service';
import { Reserva } from 'src/app/clases/reserva';

import { ClienteService } from 'src/app/services/cliente.service';
import { EmpleadoService } from 'src/app/services/empleado.service';
import { HabitacionService } from 'src/app/services/habitacion.service';
import { TipoHabitacionService } from 'src/app/services/tipo-habitacion.service';

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
	empleados: Empleado[];
	tiposhabitacion: TipoHabitacion[];
	habitaciones: Habitacion[];
	tiposHabitacion: TipoHabitacion[];

	constructor(
		private router: Router,
		private reservaService: ReservaService,
		private clienteService: ClienteService,
		private empleadoService: EmpleadoService,
		private habitacionService: HabitacionService,
		private tipoHabitacionService: TipoHabitacionService
		) { }

	ngOnInit() {
		this.reserva.cliente = new Cliente();
		this.reserva.empleado = new Empleado();
		this.reserva.habitacion = new Habitacion();
		this.reserva.habitacion.tiposhabitacion = new TipoHabitacion();

		this.clienteService.getClientes().subscribe(data => (this.clientes = data));
		this.empleadoService.getEmpleados().subscribe(data => (this.empleados = data));
		this.tipoHabitacionService.getTipoHabitaciones().subscribe(data => (this.tiposHabitacion = data));
	}

	reservaAdd(): void {
		this.reservaService.addReserva(this.reserva).subscribe(data => { alert("La reserva se registró correctamente"); });
		this.router.navigate(['/reservas']);
	}

	filtrarHabitaciones(): void {
		this.habitacionService.buscarPorTipo(this.reserva.habitacion.tiposhabitacion.id).subscribe(data => (this.habitaciones = data));
	}

}
