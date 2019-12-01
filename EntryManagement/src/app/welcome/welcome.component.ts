import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {CaptureGuestAndHostInfoServiceService} from '../capture-guest-and-host-info-service.service';
import {GuestAndHostInfo} from '../guest-and-host-info';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private captureGuestAndHostInfoServiceService: CaptureGuestAndHostInfoServiceService) {}

  ngOnInit() {
  }

}
