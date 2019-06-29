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
import { ReservaEditComponent } from './components/reserva/reserva-edit/reserva-edit.component';

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
    ReservaEditComponent
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
