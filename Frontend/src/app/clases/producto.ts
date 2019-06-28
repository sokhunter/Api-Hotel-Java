import { Categoria } from "./categoria"

export class Producto {
    id: number;
    nombre: string;
    descripcion: string;
    precio: number;
    categoria: Categoria;
}
