import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
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
  selector: 'app-reserva-edit',
  templateUrl: './reserva-edit.component.html',
  styleUrls: ['./reserva-edit.component.css']
})
export class ReservaEditComponent implements OnInit {

	// reserva: Reserva = new Reserva();
	@Input() reserva: Reserva;
	clientes: Cliente[];
	empleados: Empleado[];
	tiposhabitacion: TipoHabitacion[];
	habitaciones: Habitacion[];
	tiposHabitacion: TipoHabitacion[];

	constructor(
		private router: Router,
		private route: ActivatedRoute,
		private reservaService: ReservaService,
		private clienteService: ClienteService,
		private empleadoService: EmpleadoService,
		private habitacionService: HabitacionService,
		private tipoHabitacionService: TipoHabitacionService
		) { }

	ngOnInit() {
		this.getReserva();
		this.clienteService.getClientes().subscribe(data => (this.clientes = data));
		this.empleadoService.getEmpleados().subscribe(data => (this.empleados = data));
		this.tipoHabitacionService.getTipoHabitaciones().subscribe(data => (this.tiposHabitacion = data));
		this.filtrarHabitaciones();

	}

	getReserva(): void {
		const id = +this.route.snapshot.paramMap.get('id');
		this.reservaService.getReserva(id).subscribe(reserva => this.reserva = reserva);
	}

	filtrarHabitaciones(): void {
		this.habitacionService.buscarPorTipo(this.reserva.habitacion.tiposhabitacion.id).subscribe(data => (this.habitaciones = data));
	}

	reservaEdit(): void {
		this.reservaService.editReserva(this.reserva).subscribe(data => { alert("La reserva se actualizó correctamente"); });
		this.router.navigate(['/reservas']);
	}

}
