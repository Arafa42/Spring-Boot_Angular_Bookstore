import { Component, OnInit } from '@angular/core';
import { empty } from 'rxjs';
import { Order } from 'src/app/models/Order';
import { LocalStorageManager } from 'src/app/other/LocalStorageManager';
import { BackendService } from 'src/app/services/backend/backend.service';

@Component({
  selector: 'app-basket',
  templateUrl: './basket.component.html',
  styleUrls: ['./basket.component.scss']
})
export class BasketComponent implements OnInit
{
  orders: Order[] = [];
  totalPrice: number = 0;

  constructor(public backendService: BackendService) { }

  ngOnInit(): void
  {
    this.getOrdersFromCurrentUser(LocalStorageManager.GetCurrentMail());
    this.totalPrice = Number(LocalStorageManager.GetTotalPriceOfOrders());
  }

  getOrdersFromCurrentUser(email: string)
  {
    this.backendService.getOrdersByEmail(email).subscribe(
      data =>
      {
        console.log(data);
        this.orders = data;
        if (data.length == 0) {
          LocalStorageManager.SetTotalAmountOfOrders("0");
          LocalStorageManager.SetTotalPriceOfOrders("0.0");
        }
        console.log(this.totalPrice);
      },
      error =>
      {
        console.log(error);
      }
    );
  }
}