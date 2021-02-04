import { Component, OnInit } from '@angular/core';
import { AngularFireAuth } from '@angular/fire/auth';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/Authentication/auth.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.scss']
})
export class SigninComponent implements OnInit
{

  loginForm: FormGroup;

  constructor(private authService: AuthService,
    private router: Router,) { }

  ngOnInit(): void
  {
  }



  async login(form): Promise<void>
  {
    this.authService.Login(form.value.email, form.value.password);
  }

}
