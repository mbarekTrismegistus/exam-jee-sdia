import { Injectable, inject } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Vehicule } from '../models/vehicule.model';
import { environment } from '../../environments/environment';

@Injectable({ providedIn: 'root' })
export class VehiculeService {
  private http = inject(HttpClient);
  private baseUrl = `${environment.apiBaseUrl}/vehicules`;
  private voitureUrl = `${environment.apiBaseUrl}/voitures`;
  private motoUrl = `${environment.apiBaseUrl}/motos`;

  getAll(): Observable<Vehicule[]> { return this.http.get<Vehicule[]>(this.baseUrl); }
  getByAgence(agenceId: number): Observable<Vehicule[]> {
    return this.http.get<Vehicule[]>(`${this.baseUrl}/agence/${agenceId}`);
  }
  getByStatut(statut: string): Observable<Vehicule[]> {
    return this.http.get<Vehicule[]>(`${this.baseUrl}/statut/${statut}`);
  }
  createVoiture(voiture: any): Observable<any> { return this.http.post(this.voitureUrl, voiture); }
  createMoto(moto: any): Observable<any> { return this.http.post(this.motoUrl, moto); }
  delete(id: number): Observable<void> { return this.http.delete<void>(`${this.baseUrl}/${id}`); }
}