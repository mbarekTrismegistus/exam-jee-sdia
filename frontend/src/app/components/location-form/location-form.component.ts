import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LocationService } from '../../services/location.service';

@Component({
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './location-form.component.html'
})
export class LocationFormComponent {
  private fb = inject(FormBuilder);
  private locationService = inject(LocationService);
  private router = inject(Router);

  form = this.fb.group({
    vehiculeId: [null, Validators.required],
    dateDebut: ['', Validators.required],
    dateFin: ['', Validators.required]
  });

  onSubmit() {
    if (this.form.invalid) return;
    this.locationService.create(this.form.value).subscribe(() => {
      this.router.navigate(['/locations']);
    });
  }
}