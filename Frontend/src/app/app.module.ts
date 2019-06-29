import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { EmpleadoComponent } from './components/empleado/empleado.component';
import { ClienteComponent } from './components/cliente/cliente.component';
import { ProductoComponent } from './components/producto/producto.component';
import { ClienteAddComponent } from './components/cliente/cliente-add/cliente-add.component';
import { HabitacionComponent } from './components/habitacion/habitacion.component';
import { ReservaComponent } from './components/reserva/reserva.component';
import { CategoriaComponent } from './components/categoria/categoria.component';
import { ReservaAddComponent } from './components/reserva/reserva-add/reserva-add.component';
import { EmpleadoAddComponent } from './components/empleado/empleado-add/empleado-add.component';
import { PedidoComponent } from './components/pedido/pedido.component';
import { PedidoAddComponent } from './components/pedido/pedido-add/pedido-add.component';
import { PedidoEditComponent } from './components/pedido/pedido-edit/pedido-edit.component';
import { DetallePedidoComponent } from './components/detalle-pedido/detalle-pedido.component';
import { DetallePedidoAddComponent } from './components/detalle-pedido/detalle-pedido-add/detalle-pedido-add.component';
import { DetallePedidoEditComponent } from './components/detalle-pedido/detalle-pedido-edit/detalle-pedido-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    EmpleadoComponent,
    ClienteComponent,
    ProductoComponent,
    ClienteAddComponent,
    HabitacionComponent,
    ReservaComponent,
    CategoriaComponent,
    ReservaAddComponent,
    EmpleadoAddComponent,
    PedidoComponent,
    PedidoAddComponent,
    PedidoEditComponent,
    DetallePedidoComponent,
    DetallePedidoAddComponent,
    DetallePedidoEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
