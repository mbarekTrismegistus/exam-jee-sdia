import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Agence } from '../models/agence.model';
import { environment } from '../../environments/environment';

@Injectable({ providedIn: 'root' })
export class AgenceService {
  private http = inject(HttpClient);
  private baseUrl = `${environment.apiBaseUrl}/agences`;

  getAll(): Observable<Agence[]> { return this.http.get<Agence[]>(this.baseUrl); }
  getById(id: number): Observable<Agence> { return this.http.get<Agence>(`${this.baseUrl}/${id}`); }
  create(agence: Agence): Observable<Agence> { return this.http.post<Agence>(this.baseUrl, agence); }
  update(agence: Agence): Observable<Agence> { return this.http.put<Agence>(`${this.baseUrl}/${agence.id}`, agence); }
  delete(id: number): Observable<void> { return this.http.delete<void>(`${this.baseUrl}/${id}`); }
}