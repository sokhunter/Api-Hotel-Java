import { Component, OnInit } from '@angular/core';
import { EmpleadoService } from 'src/app/services/empleado.service';
import { Empleado } from 'src/app/clases/empleado';

@Component({
  selector: 'app-empleado',
  templateUrl: './empleado.component.html',
  styleUrls: ['./empleado.component.css']
})
export class EmpleadoComponent implements OnInit {

	empleados: Empleado[];

  	constructor(private empleadoService: EmpleadoService) { }

	ngOnInit() {
		this.empleadoService.getEmpleados().subscribe(data => (this.empleados = data));
	}

}
