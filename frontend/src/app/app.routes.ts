import { Routes } from '@angular/router';
import { AgenceListComponent } from './components/agence-list/agence-list.component';
import { AgenceFormComponent } from './components/agence-form/agence-form.component';
import { VehiculeListComponent } from './components/vehicule-list/vehicule-list.component';
import { VoitureFormComponent } from './components/voiture-form/voiture-form.component';
import { MotoFormComponent } from './components/moto-form/moto-form.component';
import { LocationListComponent } from './components/location-list/location-list.component';
import { LocationFormComponent } from './components/location-form/location-form.component';
import { LoginComponent } from './components/login/login.component';
import { authGuard } from './guards/auth.guard';
import { adminGuard } from './guards/admin.guard';

export const routes: Routes = [
  { path: 'agences', component: AgenceListComponent, canActivate: [authGuard] },
  { path: 'agences/new', component: AgenceFormComponent, canActivate: [authGuard] },
  { path: 'agences/edit/:id', component: AgenceFormComponent, canActivate: [authGuard] },
  { path: 'vehicules', component: VehiculeListComponent, canActivate: [authGuard] },
  { path: 'voitures/new', component: VoitureFormComponent, canActivate: [authGuard] },
  { path: 'motos/new', component: MotoFormComponent, canActivate: [authGuard] },
  { path: 'locations', component: LocationListComponent, canActivate: [authGuard] },
  { path: 'locations/new', component: LocationFormComponent, canActivate: [authGuard] },
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/agences', pathMatch: 'full' }
];