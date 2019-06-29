import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { map } from "rxjs/operators"
import { DetallePedido } from '../clases/detalle-pedido';

@Injectable({
  providedIn: 'root'
})
export class DetallePedidoService {
  private urlDetallesPedido = "http://localhost:8080/api/detallespedido";
  private headers = new HttpHeaders({ "Content-Type": "application/json" });

  constructor(private clientHttp: HttpClient) { }
  getDetallePedido(): Observable<DetallePedido[]> {
    return this.clientHttp.get(this.urlDetallesPedido).pipe(map(data => data as DetallePedido[]));
  }

  //detallepedido de un pedido id
  buscarDetalleDePedido(id: number): Observable<DetallePedido[]> {
    return this.clientHttp.get(`${this.urlDetallesPedido}/buscarporpedido/${id}`).pipe(map(data => data as DetallePedido[]));
  }

  //Agregar 
  addDetallePedido(detallePedido: DetallePedido): Observable<DetallePedido> {
    return this.clientHttp.post<DetallePedido>(`${this.urlDetallesPedido}/`, detallePedido, { headers: this.headers });
  }

  //Eliminar
  deleteDetallePedido(id: number): Observable<DetallePedido> {
    return this.clientHttp.delete<DetallePedido>(`${this.urlDetallesPedido}/${id}`, { headers: this.headers });
  }

  //Editar 
  editDetallePedido(detallePedido: DetallePedido): Observable<DetallePedido> {
    return this.clientHttp.put<DetallePedido>(this.urlDetallesPedido, detallePedido, { headers: this.headers });
  }
}
