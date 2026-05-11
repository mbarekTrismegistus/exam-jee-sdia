import { Routes } from '@angular/router';
import { AgenceListComponent } from './components/agence-list/agence-list.component';
import { AgenceFormComponent } from './components/agence-form/agence-form.component';
import { VehiculeListComponent } from './components/vehicule-list/vehicule-list.component';
import { VoitureFormComponent } from './components/voiture-form/voiture-form.component';
import { MotoFormComponent } from './components/moto-form/moto-form.component';
import { LocationListComponent } from './components/location-list/location-list.component';
import { LocationFormComponent } from './components/location-form/location-form.component';
import { LoginComponent } from './components/login/login.component';

export const routes: Routes = [
  { path: 'agences', component: AgenceListComponent },
  { path: 'agences/new', component: AgenceFormComponent },
  { path: 'agences/edit/:id', component: AgenceFormComponent },
  { path: 'vehicules', component: VehiculeListComponent },
  { path: 'voitures/new', component: VoitureFormComponent },
  { path: 'motos/new', component: MotoFormComponent },
  { path: 'locations', component: LocationListComponent },
  { path: 'locations/new', component: LocationFormComponent },
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/agences', pathMatch: 'full' }
];