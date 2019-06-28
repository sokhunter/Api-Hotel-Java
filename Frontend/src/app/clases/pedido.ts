import { Reserva } from "./reserva"
import { Empleado } from "./empleado"

export class Pedido {
    id: number;
    total: number;
    reserva: Reserva;
    empleado: Empleado;
}
