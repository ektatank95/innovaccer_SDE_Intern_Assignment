import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable} from 'rxjs';
import {GuestAndHostInfo} from './guest-and-host-info';


@Injectable({
  providedIn: 'root'
})
export class CaptureGuestAndHostInfoServiceService {

  private infoUrl: string;

  constructor(private http: HttpClient) {
    this.infoUrl = 'http://localhost:8080/saveGuestAndHostInfo';
  }

  public save(guestAndHostInfo: GuestAndHostInfo) {
    return this.http.post<GuestAndHostInfo>(this.infoUrl, guestAndHostInfo);
  }
}
