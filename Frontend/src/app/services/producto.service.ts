import { Injectable } from '@angular/core';
import { Producto } from "../clases/producto";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { map } from "rxjs/operators"

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

	private urlProductos = "http://localhost:8080/api/productos";
	private headers = new HttpHeaders({ "Content-Type": "application/json" });

	constructor(private clientHttp: HttpClient) { }

	//Listar 
	getProductos(): Observable<Producto[]> {
	return this.clientHttp.get(this.urlProductos).pipe(map(data => data as Producto[]));
	}

	//Agregar 
	addProducto(producto: Producto): Observable<Producto> {
	return this.clientHttp.post<Producto>(`${this.urlProductos}/`, producto, { headers: this.headers });
	}

	//Eliminar
	deleteProducto(id: number): Observable<Producto> {
	return this.clientHttp.delete<Producto>(`${this.urlProductos}/${id}`, { headers: this.headers });
	}

	//Editar 
	editProducto(producto: Producto): Observable<Producto> {
	return this.clientHttp.put<Producto>(this.urlProductos, producto, { headers: this.headers });
	}
}
