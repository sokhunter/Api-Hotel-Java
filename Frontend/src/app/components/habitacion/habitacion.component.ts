import { Component, OnInit } from '@angular/core';
import { HabitacionService } from 'src/app/services/habitacion.service';
import { Habitacion } from 'src/app/clases/habitacion';

@Component({
  selector: 'app-habitacion',
  templateUrl: './habitacion.component.html',
  styleUrls: ['./habitacion.component.css']
})
export class HabitacionComponent implements OnInit {

	habitaciones: Habitacion[];

  	constructor(private habitacionService: HabitacionService) { }

  	ngOnInit() {
  		this.habitacionService.getHabitaciones().subscribe(data => (this.habitaciones = data));
	}

}
