import { Producto } from './producto';
import { Pedido } from './pedido';

export class DetallePedido {
    id: number;
    precio: number
    cantidad: number;
    producto: Producto;
    pedido: Pedido;
}
