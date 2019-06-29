import { Component, OnInit } from '@angular/core';
import { Empleado } from 'src/app/clases/empleado';
import { TipoDocumento } from 'src/app/clases/tipo-documento';
import { EmpleadoService } from 'src/app/services/empleado.service';

@Component({
  selector: 'app-empleado-add',
  templateUrl: './empleado-add.component.html',
  styleUrls: ['./empleado-add.component.css']
})
export class EmpleadoAddComponent implements OnInit {
  empleado: Empleado = new Empleado();
  tiposDocumento: TipoDocumento[];

  constructor(private empleadoService: EmpleadoService) { }

  ngOnInit() {
    this.empleado.tipodocumento = new TipoDocumento();
  }
  empleadoAdd(): void {
    console.log(this.empleado);
    this.empleadoService.addEmpleado(this.empleado).subscribe(data => { alert("El empleado se registró correctamente"); });
  }
}