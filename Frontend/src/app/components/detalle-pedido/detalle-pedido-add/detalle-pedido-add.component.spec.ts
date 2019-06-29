import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetallePedidoAddComponent } from './detalle-pedido-add.component';

describe('DetallePedidoAddComponent', () => {
  let component: DetallePedidoAddComponent;
  let fixture: ComponentFixture<DetallePedidoAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetallePedidoAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetallePedidoAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
