import { Reserva } from "./reserva"

export class Pedido {
    id: number;
    total: number;
    fregistro:Date;
    reserva: Reserva;
}
