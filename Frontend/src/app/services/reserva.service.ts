import { Injectable } from '@angular/core';
import { Reserva } from "../clases/reserva";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { map } from "rxjs/operators"

@Injectable({
  providedIn: 'root'
})
export class ReservaService {

	private urlReservas = "http://localhost:8080/api/reservas";
	private headers = new HttpHeaders({ "Content-Type": "application/json" });

	constructor(private clientHttp: HttpClient) { }

	//Listar 
	getReservas(): Observable<Reserva[]> {
	return this.clientHttp.get(this.urlReservas).pipe(map(data => data as Reserva[]));
	}

	//Agregar 
	addReserva(reserva: Reserva): Observable<Reserva> {
	return this.clientHttp.post<Reserva>(`${this.urlReservas}/`, reserva, { headers: this.headers });
	}

	//Eliminar
	deleteReserva(id: number): Observable<Reserva> {
	return this.clientHttp.delete<Reserva>(`${this.urlReservas}/${id}`, { headers: this.headers });
	}

	//Editar 
	editReserva(reserva: Reserva): Observable<Reserva> {
	return this.clientHttp.put<Reserva>(this.urlReservas, reserva, { headers: this.headers });
	}
}
