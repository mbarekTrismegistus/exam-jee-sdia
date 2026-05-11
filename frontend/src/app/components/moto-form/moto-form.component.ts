import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { VehiculeService } from '../../services/vehicule.service';

@Component({
  selector: 'app-moto-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterLink],
  templateUrl: './moto-form.component.html'
})
export class MotoFormComponent {
  private fb = inject(FormBuilder);
  private vehiculeService = inject(VehiculeService);
  private router = inject(Router);

  form: FormGroup;

  constructor() {
    this.form = this.fb.group({
      marque: ['', Validators.required],
      modele: ['', Validators.required],
      matricule: ['', Validators.required],
      prixParJour: [0, [Validators.required, Validators.min(1)]],
      dateMiseEnService: ['', Validators.required],
      statut: ['DISPONIBLE', Validators.required],
      agenceId: [null, Validators.required],
      cylindree: [125, [Validators.required, Validators.min(50)]],
      typeMoto: ['ROADSTER', Validators.required],
      casqueInclus: ['OUI', Validators.required]
    });
  }

  onSubmit(): void {
    if (this.form.invalid) return;
    this.vehiculeService.createMoto(this.form.value).subscribe({
      next: () => this.router.navigate(['/vehicules']),
      error: (err) => console.error('Erreur création moto', err)
    });
  }
}