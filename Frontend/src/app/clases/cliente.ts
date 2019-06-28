import { TipoDocumento } from "./tipo-documento";

export class Cliente {
    id: number;
    nombre: string;
    apaterno: string;
    amaterno: string;
    telefono: number;
    fnacimiento: string;
    fregistro: string;
    numerodocumento: string;
    vip: boolean;
    eliminado: boolean;
    tipodocumento: TipoDocumento;
}