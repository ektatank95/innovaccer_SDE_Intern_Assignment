import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CaptureGuestAndHostInfoComponent } from './capture-guest-and-host-info.component';

describe('CaptureGuestAndHostInfoComponent', () => {
  let component: CaptureGuestAndHostInfoComponent;
  let fixture: ComponentFixture<CaptureGuestAndHostInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CaptureGuestAndHostInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CaptureGuestAndHostInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
