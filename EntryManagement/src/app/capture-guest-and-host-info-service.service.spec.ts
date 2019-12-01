import { TestBed } from '@angular/core/testing';

import { CaptureGuestAndHostInfoServiceService } from './capture-guest-and-host-info-service.service';

describe('CaptureGuestAndHostInfoServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CaptureGuestAndHostInfoServiceService = TestBed.get(CaptureGuestAndHostInfoServiceService);
    expect(service).toBeTruthy();
  });
});
