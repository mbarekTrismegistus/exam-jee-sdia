import { Component, inject, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { AgenceService } from '../../services/agence.service';
import { Agence } from '../../models/agence.model';

@Component({
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './agence-list.component.html'
})
export class AgenceListComponent {
  private agenceService = inject(AgenceService);
  agences = signal<Agence[]>([]);

  constructor() {
    this.loadAgences();
  }

  loadAgences() {
    this.agenceService.getAll().subscribe(data => this.agences.set(data));
  }

  deleteAgence(id: number) {
    if (confirm('Supprimer cette agence ?')) {
      this.agenceService.delete(id).subscribe(() => this.loadAgences());
    }
  }
}