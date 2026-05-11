import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  standalone: true,
  imports: [CommonModule],
  template: `<div class="alert alert-info">Page de connexion (à implémenter avec JWT)</div>`
})
export class LoginComponent {}