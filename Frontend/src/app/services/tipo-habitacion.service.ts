import { Injectable } from '@angular/core';
import { TipoHabitacion } from "../clases/tipo-habitacion";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { map } from "rxjs/operators"

@Injectable({
  providedIn: 'root'
})
export class TipoHabitacionService {

  	private urlTiposHabitacion = "http://localhost:8080/api/tiposhabitacion";
	private headers = new HttpHeaders({ "Content-Type": "application/json" });

	constructor(private clientHttp: HttpClient) { }

	//Listar 
	getTipoHabitaciones(): Observable<TipoHabitacion[]> {
	return this.clientHttp.get(this.urlTiposHabitacion).pipe(map(data => data as TipoHabitacion[]));
	}

	//Agregar 
	addTipoHabitacion(tiposhabitacion: TipoHabitacion): Observable<TipoHabitacion> {
	return this.clientHttp.post<TipoHabitacion>(`${this.urlTiposHabitacion}/`, tiposhabitacion, { headers: this.headers });
	}

	//Eliminar
	deleteTipoHabitacion(id: number): Observable<TipoHabitacion> {
	return this.clientHttp.delete<TipoHabitacion>(`${this.urlTiposHabitacion}/${id}`, { headers: this.headers });
	}

	//Editar 
	editTipoHabitacion(tiposhabitacion: TipoHabitacion): Observable<TipoHabitacion> {
	return this.clientHttp.put<TipoHabitacion>(this.urlTiposHabitacion, tiposhabitacion, { headers: this.headers });
	}
}
