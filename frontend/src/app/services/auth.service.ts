// auth.service.ts
import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';
import { TokenService } from './token.service';
import { environment } from '../../environments/environment';

interface LoginRequest {
  username: string;
  password: string;
}

interface LoginResponse {
  token: string;
  role: string;
}

@Injectable({ providedIn: 'root' })
export class AuthService {
  private http = inject(HttpClient);
  private tokenService = inject(TokenService);
  private baseUrl = '/api/auth';

  login(username: string, password: string): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(`${environment.apiBaseUrl}/auth/login`, {
      username,
      password
    } as LoginRequest).pipe(
      tap(response => {
        this.tokenService.setToken(response.token);
      })
    );
  }

  logout(): void {
    this.tokenService.removeToken();
  }

  getRole(): string | null {
    const token = this.tokenService.getToken();
    if (!token) return null;
    try {
      const payload = JSON.parse(atob(token.split('.')[1]));
      return payload.role;
    } catch {
      return null;
    }
  }

  isLoggedIn(): boolean {
    return this.tokenService.isLoggedIn();
  }

  isAdmin(): boolean {
    return this.getRole() === 'ROLE_ADMIN';
  }

  isEmploye(): boolean {
    return this.getRole() === 'ROLE_EMPLOYE';
  }

  isClient(): boolean {
    return this.getRole() === 'ROLE_CLIENT';
  }

  canModify(): boolean {
    return this.isAdmin() || this.isEmploye();
  }

  canDelete(): boolean {
    return this.isAdmin();
  }
}