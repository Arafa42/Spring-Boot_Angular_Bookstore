import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-bottomnavigation',
  templateUrl: './bottomnavigation.component.html',
  styleUrls: ['./bottomnavigation.component.scss']
})
export class BottomnavigationComponent implements OnInit
{

  constructor(private router: Router)
  {

  }

  ngOnInit(): void
  {
  }


  navigate()
  {
    this.router.navigate(["/books"]);
  }

}
