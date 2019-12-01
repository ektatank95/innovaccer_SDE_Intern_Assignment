import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CaptureGuestAndHostInfoComponent } from './capture-guest-and-host-info/capture-guest-and-host-info.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {CaptureGuestAndHostInfoServiceService} from './capture-guest-and-host-info-service.service';
import { WelcomeComponent } from './welcome/welcome.component';

@NgModule({
  declarations: [
    AppComponent,
    CaptureGuestAndHostInfoComponent,
    WelcomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [CaptureGuestAndHostInfoServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
