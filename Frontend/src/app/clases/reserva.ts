import { Empleado } from "./empleado"
import { Cliente } from "./cliente"
import { Habitacion } from "./habitacion"

export class Reserva {
    id: number;
    monto: number;
    comentario: string;
    camas: number;
    finicio: string;
    ffin: string;
    fregistro: string;
    descuento: number;
    empleado: Empleado;
    cliente: Cliente;
    habitacion: Habitacion;
    anulado: boolean;
}
