import { Component, inject, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { VehiculeService } from '../../services/vehicule.service';
import { Vehicule } from '../../models/vehicule.model';
import { FormsModule } from '@angular/forms';

@Component({
  standalone: true,
  imports: [CommonModule, RouterLink, FormsModule],
  templateUrl: './vehicule-list.component.html'
})
export class VehiculeListComponent {
  private vehiculeService = inject(VehiculeService);

  vehicules = signal<Vehicule[]>([]);
  filterStatut = '';
  filterAgenceId?: number;

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