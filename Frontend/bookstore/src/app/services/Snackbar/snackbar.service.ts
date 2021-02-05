import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class SnackbarService
{
  constructor(private matSnackBar: MatSnackBar) { }

  ShowErrorMessage(input: string)
  {
    this.matSnackBar.open(input, 'OK', {
      duration: 3000
    });
  }

  ShowSuccesMessage(input: string)
  {
    this.matSnackBar.open(input, '', {
      duration: 1000
    });
  }

  ShowCustomMessage(input: string)
  {
    this.matSnackBar.open(input, '', { duration: 3000 });
  }
}