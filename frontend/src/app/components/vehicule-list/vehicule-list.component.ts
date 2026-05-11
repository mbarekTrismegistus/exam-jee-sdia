// vehicule-list.component.ts
import { Component, inject, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { VehiculeService } from '../../services/vehicule.service';
import { AuthService } from '../../services/auth.service';
import { Vehicule } from '../../models/vehicule.model';

@Component({
  standalone: true,
  imports: [CommonModule, RouterLink, FormsModule],
  templateUrl: './vehicule-list.component.html'
})
export class VehiculeListComponent {
  private vehiculeService = inject(VehiculeService);
  private authService = inject(AuthService);

  vehicules = signal<Vehicule[]>([]);
  filterStatut = '';
  filterAgenceId?: number;

  get canModify(): boolean {
    return this.authService.canModify();
  }

  get canDelete(): boolean {
    return this.authService.canDelete();
  }

  constructor() {
    this.loadVehicules();
  }

  loadVehicules() {
    if (this.filterStatut) {
      this.vehiculeService.getByStatut(this.filterStatut).subscribe(data => this.vehicules.set(data));
    } else if (this.filterAgenceId) {
      this.vehiculeService.getByAgence(this.filterAgenceId).subscribe(data => this.vehicules.set(data));
    } else {
      this.vehiculeService.getAll().subscribe(data => this.vehicules.set(data));
    }
  }

  applyFilter() {
    this.loadVehicules();
  }

  deleteVehicle(id: number) {
    if (confirm('Supprimer ce véhicule ?')) {
      this.vehiculeService.delete(id).subscribe(() => this.loadVehicules());
    }
  }
}