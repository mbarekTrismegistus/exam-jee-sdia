import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { VehiculeService } from '../../services/vehicule.service';

@Component({
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './voiture-form.component.html'
})
export class VoitureFormComponent {
  private fb = inject(FormBuilder);
  private vehiculeService = inject(VehiculeService);
  private router = inject(Router);

  form = this.fb.group({
    marque: ['', Validators.required],
    modele: ['', Validators.required],
    matricule: ['', Validators.required],
    prixParJour: [0, [Validators.required, Validators.min(1)]],
    dateMiseEnService: ['', Validators.required],
    statut: ['DISPONIBLE', Validators.required],
    agenceId: [null, Validators.required],
    nombrePortes: [5, Validators.required],
    typeCarburant: ['ESSENCE', Validators.required],
    boiteVitesse: ['MANUELLE', Validators.required]
  });

  onSubmit() {
    if (this.form.invalid) return;
    this.vehiculeService.createVoiture(this.form.value).subscribe(() => this.router.navigate(['/vehicules']));
  }
}