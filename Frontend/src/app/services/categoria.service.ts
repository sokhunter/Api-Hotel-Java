import { Injectable } from '@angular/core';
import { Categoria } from "../clases/categoria";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { map } from "rxjs/operators"

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

	private urlCategorias = "http://localhost:8080/api/categorias";
	private headers = new HttpHeaders({ "Content-Type": "application/json" });

	constructor(private clientHttp: HttpClient) { }

	//Listar 
	getCategorias(): Observable<Categoria[]> {
	return this.clientHttp.get(this.urlCategorias).pipe(map(data => data as Categoria[]));
	}

	//Agregar 
	addCategoria(categoria: Categoria): Observable<Categoria> {
	return this.clientHttp.post<Categoria>(`${this.urlCategorias}/`, categoria, { headers: this.headers });
	}

	//Eliminar
	deleteCategoria(id: number): Observable<Categoria> {
	return this.clientHttp.delete<Categoria>(`${this.urlCategorias}/${id}`, { headers: this.headers });
	}

	//Editar 
	editCategoria(categoria: Categoria): Observable<Categoria> {
	return this.clientHttp.put<Categoria>(this.urlCategorias, categoria, { headers: this.headers });
	}
}
