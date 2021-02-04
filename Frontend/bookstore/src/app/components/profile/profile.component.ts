import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/Authentication/auth.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit
{

  constructor(public AuthService: AuthService) { }

  ngOnInit(): void
  {
  }


  logOut()
  {
    this.AuthService.Logout();
  }


}
