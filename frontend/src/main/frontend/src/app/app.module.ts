import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {routing} from './app.routing';

import {AlertService, AuthenticationService} from './_services/index'; // , UserService
import {AuthGuard} from './_guards/index';
import {AlertComponent} from './_directives/index';
import {MockBackend} from '@angular/http/testing';

import {LoginComponent} from './login/index';
import {RegisterComponent} from './register/index';
import {HomeComponent} from './home/index';
import {UserService} from './_services/user.service';
import {UrlService} from "./_services/url.service"

import {AppComponent} from './app.component';
import {UserService2} from './services/user.service';

@NgModule({
  declarations: [
    AppComponent,
    AlertComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent
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
    UserService2,
    UserService,
    UrlService,

    // providers used to create fake backend
    MockBackend,
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
