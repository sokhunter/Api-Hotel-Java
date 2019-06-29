import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { map } from "rxjs/operators"
import { Pedido } from '../clases/pedido';


@Injectable({
  providedIn: 'root'
})
export class PedidoService {
  private urlPedidos = "http://localhost:8080/api/pedidos";
  private headers = new HttpHeaders({ "Content-Type": "application/json" });

  constructor(private clientHttp: HttpClient) { }
  getPedidos(): Observable<Pedido[]> {
    return this.clientHttp.get(this.urlPedidos).pipe(map(data => data as Pedido[]));
  }
  getPedido(id: number): Observable<Pedido> {
    return this.clientHttp.get<Pedido>(`${this.urlPedidos}/${id}`).pipe();
  }

  //Agregar 
  addPedido(pedido: Pedido): Observable<Pedido> {
    return this.clientHttp.post<Pedido>(`${this.urlPedidos}/`, pedido, { headers: this.headers });
  }

  //Eliminar
  deletePedido(id: number): Observable<Pedido> {
    return this.clientHttp.delete<Pedido>(`${this.urlPedidos}/${id}`, { headers: this.headers });
  }

  //Editar 
  editPedido(pedido: Pedido): Observable<Pedido> {
    return this.clientHttp.put<Pedido>(this.urlPedidos, pedido, { headers: this.headers });
  }

}
