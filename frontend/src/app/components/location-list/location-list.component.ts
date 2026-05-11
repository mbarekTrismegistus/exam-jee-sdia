// location-list.component.ts
import { Component, inject, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { LocationService } from '../../services/location.service';
import { AuthService } from '../../services/auth.service';
import { Location } from '../../models/location.model';

@Component({
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './location-list.component.html'
})
export class LocationListComponent {
  private locationService = inject(LocationService);
  private authService = inject(AuthService);
  locations = signal<Location[]>([]);

  get canModify(): boolean {
    return this.authService.canModify(); // EMPLOYEE or ADMIN
  }

  get canCreate(): boolean {
    return this.authService.isLoggedIn(); // any authenticated user can create a location
  }

  constructor() {
    this.loadLocations();
  }

  loadLocations() {
    this.locationService.getAll().subscribe(data => this.locations.set(data));
  }

  returnVehicle(locId: number) {
    if (confirm('Marquer le véhicule comme rendu ?')) {
      this.locationService.returnVehicule(locId).subscribe(() => {
        this.loadLocations();
      });
    }
  }
}