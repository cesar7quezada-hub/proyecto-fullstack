import { HttpClient } from '@angular/common/http';
import { Component, OnInit, signal } from '@angular/core';
import { Router } from '@angular/router';

import { environment } from '../../../../environments/environment';
import { AuthService } from '../../../core/services/auth.service';

interface Poliza {
  id: number;
  numeroPoliza: string;
  ramo: string;
  cliente: string;
  estado: string;
}

@Component({
  selector: 'app-dashboard',
  imports: [],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.scss'
})
export class Dashboard implements OnInit {
  protected readonly polizas = signal<Poliza[]>([]);
  protected readonly loading = signal(true);
  protected readonly errorMessage = signal<string | null>(null);

  constructor(
    private readonly http: HttpClient,
    protected readonly authService: AuthService,
    private readonly router: Router
  ) {}

  ngOnInit(): void {
    this.http.get<Poliza[]>(`${environment.apiUrl}/polizas`).subscribe({
      next: (data) => {
        this.polizas.set(data);
        this.loading.set(false);
      },
      error: () => {
        this.errorMessage.set('No se pudieron cargar las pólizas. Intenta de nuevo.');
        this.loading.set(false);
      }
    });
  }

  logout(): void {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}
