import { HttpClient } from '@angular/common/http';
import { Injectable, computed, signal } from '@angular/core';
import { Observable, tap } from 'rxjs';

import { environment } from '../../../environments/environment';
import { LoginRequest, LoginResponse } from '../../shared/models/auth.model';

const TOKEN_KEY = 'auth_token';
const USERNAME_KEY = 'auth_username';

@Injectable({ providedIn: 'root' })
export class AuthService {
  private readonly storage: Storage =
    environment.tokenStorage === 'localStorage' ? localStorage : sessionStorage;

  private readonly tokenSignal = signal<string | null>(this.storage.getItem(TOKEN_KEY));
  private readonly usernameSignal = signal<string | null>(this.storage.getItem(USERNAME_KEY));

  readonly isAuthenticated = computed(() => this.tokenSignal() !== null);
  readonly username = this.usernameSignal.asReadonly();

  constructor(private readonly http: HttpClient) {}

  login(credentials: LoginRequest): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(`${environment.apiUrl}/auth/login`, credentials).pipe(
      tap((response) => {
        this.storage.setItem(TOKEN_KEY, response.token);
        this.storage.setItem(USERNAME_KEY, credentials.username);
        this.tokenSignal.set(response.token);
        this.usernameSignal.set(credentials.username);
      })
    );
  }

  logout(): void {
    this.storage.removeItem(TOKEN_KEY);
    this.storage.removeItem(USERNAME_KEY);
    this.tokenSignal.set(null);
    this.usernameSignal.set(null);
  }

  getToken(): string | null {
    return this.tokenSignal();
  }
}
