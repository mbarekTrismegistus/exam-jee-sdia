import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AgenceService } from '../../services/agence.service';

@Component({
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './agence-form.component.html'
})
export class AgenceFormComponent implements OnInit {
  private fb = inject(FormBuilder);
  private agenceService = inject(AgenceService);
  private route = inject(ActivatedRoute);
  private router = inject(Router);

  form: FormGroup;
  isEdit = false;
  agenceId?: number;

  constructor() {
    this.form = this.fb.group({
      nom: ['', Validators.required],
      adresse: ['', Validators.required],
      ville: ['', Validators.required],
      telephone: ['', Validators.required]
    });
  }

  ngOnInit() {
    this.agenceId = Number(this.route.snapshot.paramMap.get('id'));
    if (this.agenceId) {
      this.isEdit = true;
      this.agenceService.getById(this.agenceId).subscribe(agence => {
        this.form.patchValue(agence);
      });
    }
  }

  onSubmit() {
    if (this.form.invalid) return;

    const agence: any = this.form.value;
    if (this.isEdit) {
      agence.id = this.agenceId;
      this.agenceService.update(agence).subscribe(() => this.router.navigate(['/agences']));
    } else {
      this.agenceService.create(agence).subscribe(() => this.router.navigate(['/agences']));
    }
  }
}