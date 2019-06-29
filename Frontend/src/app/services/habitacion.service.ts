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
	getHabitaciones(): Observable<Habitacion[]> {
		return this.clientHttp.get(this.urlHabitaciones).pipe(map(data => data as Habitacion[]));
	}

	//Agregar 
	addHabitacion(habitacion: Habitacion): Observable<Habitacion> {
		return this.clientHttp.post<Habitacion>(`${this.urlHabitaciones}/`, habitacion, { headers: this.headers });
	}

	//Eliminar
	deleteHabitacion(id: number): Observable<Habitacion> {
		return this.clientHttp.delete<Habitacion>(`${this.urlHabitaciones}/${id}`, { headers: this.headers });
	}

	//Editar 
	editHabitacion(habitacion: Habitacion): Observable<Habitacion> {
		return this.clientHttp.put<Habitacion>(this.urlHabitaciones, habitacion, { headers: this.headers });
	}
}
