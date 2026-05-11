import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Vehicule } from '../models/vehicule.model';
import { environment } from '../../environments/environment';

@Injectable({ providedIn: 'root' })
export class VehiculeService {
  private http = inject(HttpClient);
  private baseUrl = environment.apiBaseUrl;

  getByAgence(agenceId: number): Observable<Vehicule[]> {
    return this.http.get<Vehicule[]>(`${this.baseUrl}/agence/${agenceId}`);
  }

  getByStatut(statut: string): Observable<Vehicule[]> {
    return this.http.get<Vehicule[]>(`${this.baseUrl}/statut/${statut}`);
  }
}