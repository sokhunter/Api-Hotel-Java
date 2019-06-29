import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetallePedidoEditComponent } from './detalle-pedido-edit.component';

describe('DetallePedidoEditComponent', () => {
  let component: DetallePedidoEditComponent;
  let fixture: ComponentFixture<DetallePedidoEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetallePedidoEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetallePedidoEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
