import { TipoDocumento } from "./tipo-documento";

export class Empleado {
    id: number;
    nombre: string;
    apaterno: string;
    amaterno: string;
    fnacimiento: string;
    fregistro: string;
    tipodocumento: TipoDocumento;
    numerodocumento: string;
    eliminado: boolean;
}
