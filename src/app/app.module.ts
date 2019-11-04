import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { FetchDataService } from './fetch-data.service';
import { DashboardComponent } from './dashboard/dashboard.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    NavBarComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
     AppRoutingModule,
   
  ],
  providers: [FetchDataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
