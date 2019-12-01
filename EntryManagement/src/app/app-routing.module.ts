import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CaptureGuestAndHostInfoComponent} from './capture-guest-and-host-info/capture-guest-and-host-info.component';
import {WelcomeComponent} from './welcome/welcome.component';



const routes: Routes = [
  { path: 'saveGuestAndHostInfo', component: CaptureGuestAndHostInfoComponent },

  {
    path: 'welcome',
    component: WelcomeComponent
  },
  { path: '',
    redirectTo: '/welcome',
    pathMatch: 'full'
  },

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
