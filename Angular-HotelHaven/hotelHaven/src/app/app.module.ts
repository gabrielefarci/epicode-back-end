import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './components/register/register.component';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AddHomeComponent } from './components/add-home/add-home.component';
import { Pagina1Component } from './components/pagina1/pagina1.component';
import { Pagina2Component } from './components/pagina2/pagina2.component';
import { Pagina3Component } from './components/pagina3/pagina3.component';
import { MappaComponent } from './components/mappa/mappa.component';
import { Pagina4Component } from './components/pagina4/pagina4.component';
import { CitiesComponent } from './components/cities/cities.component';
import { TypeaheadModule } from 'ngx-bootstrap/typeahead';
import { AddressAutocompleteComponent } from './components/address-autocomplete/address-autocomplete.component';
import { Pagina5Component } from './components/pagina5/pagina5.component';
import { Pagina6Component } from './components/pagina6/pagina6.component';
import { Pagina7Component } from './components/pagina7/pagina7.component';
import { Pagina8Component } from './components/pagina8/pagina8.component';
import { NgxDropzoneModule } from 'ngx-dropzone';
import { FooterBtnComponent } from './components/footer-btn/footer-btn.component';
import { Pagina9Component } from './components/pagina9/pagina9.component';
import { Pagina10Component } from './components/pagina10/pagina10.component';
import { Pagina11Component } from './components/pagina11/pagina11.component';
import { Pagina12Component } from './components/pagina12/pagina12.component';
import { Pagina13Component } from './components/pagina13/pagina13.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    HeaderComponent,
    HomeComponent,
    LoginComponent,
    AddHomeComponent,
    Pagina1Component,
    Pagina2Component,
    Pagina3Component,
    MappaComponent,
    Pagina4Component,
    CitiesComponent,
    AddressAutocompleteComponent,
    Pagina5Component,
    Pagina6Component,
    Pagina7Component,
    Pagina8Component,
    FooterBtnComponent,
    Pagina9Component,
    Pagina10Component,
    Pagina11Component,
    Pagina12Component,
    Pagina13Component
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    TypeaheadModule.forRoot(),
    NgxDropzoneModule
  ],
  providers: [
    AddressAutocompleteComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
