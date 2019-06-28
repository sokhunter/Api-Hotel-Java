import { Injectable } from '@angular/core';
import { Empleado } from "../clases/empleado";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { map } from "rxjs/operators"

@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {
  private urlEmpleados = "http://localhost:8080/api/empleados";
  private headers = new HttpHeaders({ "Content-Type": "application/json" });

  constructor(private clientHttp: HttpClient) { }

  //Listar 
  getEmpleados(): Observable<Empleado[]> {
    return this.clientHttp.get(this.urlEmpleados).pipe(map(data => data as Empleado[]));
  }

  //Agregar 
  addEmpleado(empleado: Empleado): Observable<Empleado> {
    return this.clientHttp.post<Empleado>(`${this.urlEmpleados}/`, empleado, { headers: this.headers });
  }

  //Eliminar
  deleteEmpleado(id: number): Observable<Empleado> {
    return this.clientHttp.delete<Empleado>(`${this.urlEmpleados}/${id}`, { headers: this.headers });
  }

  //Editar 
  editEmpleado(empleado: Empleado): Observable<Empleado> {
    return this.clientHttp.put<Empleado>(this.urlEmpleados, empleado, { headers: this.headers });
  }
}
