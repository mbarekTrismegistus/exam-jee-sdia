import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Location } from '../models/location.model';
import { environment } from '../../environments/environment';

@Injectable({ providedIn: 'root' })
export class LocationService {
  private http = inject(HttpClient);
  private baseUrl = environment.apiBaseUrl;

  getAll(): Observable<Location[]> {
    return this.http.get<Location[]>(this.baseUrl);
  }

  create(location: Location): Observable<Location> {
    return this.http.post<Location>(this.baseUrl, location);
  }

  returnVehicule(id: number): Observable<Location> {
    return this.http.patch<Location>(`${this.baseUrl}/${id}/retour`, {});
  }
}