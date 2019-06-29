import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClienteComponent } from './components/cliente/cliente.component';
import { EmpleadoComponent } from './components/empleado/empleado.component';
import { HabitacionComponent } from './components/habitacion/habitacion.component';
import { ReservaComponent } from './components/reserva/reserva.component';
import { CategoriaComponent } from './components/categoria/categoria.component';
import { ProductoComponent } from './components/producto/producto.component';
// import { TipohabitacionComponent } from './components/cliente/cliente-add/cliente-add.component';

import { ClienteAddComponent } from './components/cliente/cliente-add/cliente-add.component';
import { ReservaAddComponent } from './components/reserva/reserva-add/reserva-add.component';
import { ReservaEditComponent } from './components/reserva/reserva-edit/reserva-edit.component';
import { EmpleadoAddComponent } from './components/empleado/empleado-add/empleado-add.component';
import { PedidoComponent } from './components/pedido/pedido.component';
import { PedidoAddComponent } from './components/pedido/pedido-add/pedido-add.component';
import { DetallePedidoComponent } from './components/detalle-pedido/detalle-pedido.component';

const routes: Routes = [
  { path: 'clientes', component: ClienteComponent },
  { path: 'empleados', component: EmpleadoComponent },
  { path: 'habitaciones', component: HabitacionComponent },
  { path: 'reservas', component: ReservaComponent },
  { path: 'categorias', component: CategoriaComponent },
  { path: 'productos', component: ProductoComponent },
  { path: 'pedidos', component: PedidoComponent },
  { path: 'detallespedido/:id', component: DetallePedidoComponent },

  { path: 'cliente-agregar', component: ClienteAddComponent },
  { path: 'agregar-reserva', component: ReservaAddComponent },

  { path: 'editar-reserva/:id', component: ReservaEditComponent },
  { path: 'empleado-agregar', component: EmpleadoAddComponent },
  { path: 'pedido-agregar', component: PedidoAddComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
