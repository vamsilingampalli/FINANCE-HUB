import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserviewformComponent } from './userviewform.component';

describe('UserviewformComponent', () => {
  let component: UserviewformComponent;
  let fixture: ComponentFixture<UserviewformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserviewformComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserviewformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
