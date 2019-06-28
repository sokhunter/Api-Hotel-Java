import { Injectable } from '@angular/core';
import { Habitacion } from "../clases/habitacion";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { map } from "rxjs/operators"

@Injectable({
  providedIn: 'root'
})
export class HabitacionService {

	private urlHabitaciones = "http://localhost:8080/api/habitaciones";
	private headers = new HttpHeaders({ "Content-Type": "application/json" });

	constructor(private clientHttp: HttpClient) { }

	//Listar 
	getHabitaciones(): Observable<habitacion[]> {
	return this.clientHttp.get(this.urlHabitaciones).pipe(map(data => data as habitacion[]));
	}

	//Agregar 
	addHabitacion(habitacion: habitacion): Observable<habitacion> {
	return this.clientHttp.post<habitacion>(`${this.urlHabitaciones}/`, habitacion, { headers: this.headers });
	}

	//Eliminar
	deleteHabitacion(id: number): Observable<habitacion> {
	return this.clientHttp.delete<habitacion>(`${this.urlHabitaciones}/${id}`, { headers: this.headers });
	}

	//Editar 
	editHabitacion(habitacion: habitacion): Observable<habitacion> {
	return this.clientHttp.put<habitacion>(this.urlHabitaciones, habitacion, { headers: this.headers });
	}
}
