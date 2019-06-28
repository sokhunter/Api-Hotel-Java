import { Injectable } from '@angular/core';
import { Cliente } from "../clases/cliente";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { map } from "rxjs/operators"

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
	
	private urlClientes = "http://localhost:8080/api/clientes";
	private headers = new HttpHeaders({ "Content-Type": "application/json" });

	constructor(private clientHttp: HttpClient) { }

	//Listar 
	getClientes(): Observable<Cliente[]> {
	return this.clientHttp.get(this.urlClientes).pipe(map(data => data as Cliente[]));
	}

	//Agregar 
	addCliente(cliente: Cliente): Observable<Cliente> {
	return this.clientHttp.post<Cliente>(`${this.urlClientes}/`, cliente, { headers: this.headers });
	}

	//Eliminar
	deleteCliente(id: number): Observable<Cliente> {
	return this.clientHttp.delete<Cliente>(`${this.urlClientes}/${id}`, { headers: this.headers });
	}

	//Editar 
	editCliente(cliente: Cliente): Observable<Cliente> {
	return this.clientHttp.put<Cliente>(this.urlClientes, cliente, { headers: this.headers });
	}
}
