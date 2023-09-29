import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { AddHomeComponent } from './components/add-home/add-home.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'register', component: HomeComponent},
  {path: 'login', component: HomeComponent},
  {path: 'addHome', component: AddHomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
