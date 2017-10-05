import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { routing } from './app.routing';

import { AlertService, AuthenticationService } from './_services/index'; // , UserService
import { AuthGuard } from './_guards/index';
import { MockBackend, MockConnection } from '@angular/http/testing';

import { AppComponent } from './app.component';
import { UserService } from 'app/services/user.service';
@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  providers: [
        AuthGuard,
        AlertService,
        AuthenticationService,
        UserService,

        // providers used to create fake backend
        MockBackend,
],
  bootstrap: [AppComponent]
})
export class AppModule { }
