import { Component} from '@angular/core';
import {GuestAndHostInfo} from '../guest-and-host-info';
import {ActivatedRoute, Router} from '@angular/router';
import {CaptureGuestAndHostInfoServiceService} from '../capture-guest-and-host-info-service.service';

@Component({
  selector: 'app-capture-guest-and-host-info',
  templateUrl: './capture-guest-and-host-info.component.html',
  styleUrls: ['./capture-guest-and-host-info.component.css']
})
export class CaptureGuestAndHostInfoComponent  {

  guestAndHostInfo: GuestAndHostInfo;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private captureGuestAndHostInfoServiceService: CaptureGuestAndHostInfoServiceService) {
    this.guestAndHostInfo = new GuestAndHostInfo();
  }

  onSubmit() {
    console.log('i am here');
    this.captureGuestAndHostInfoServiceService.save(this.guestAndHostInfo).subscribe(result => this.goToWelcome());
    console.log('i am done');
  }

  goToWelcome() {
    this.router.navigate(['/welcome']);
  }

}
