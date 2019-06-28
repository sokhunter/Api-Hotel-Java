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

const routes: Routes = [
  { path: 'clientes', component: ClienteComponent },
  { path: 'empleados', component: EmpleadoComponent},
  { path: 'habitaciones', component: HabitacionComponent},
  { path: 'reservas', component: ReservaComponent},
  { path: 'categorias', component: CategoriaComponent},
  { path: 'productos', component: ProductoComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
