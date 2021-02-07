import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ICreateOrderRequest, IPayPalConfig } from 'ngx-paypal';
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

  public payPalConfig?: IPayPalConfig;
  orders: Order[] = [];
  totalPrice: number = 0;

  constructor(public backendService: BackendService) { }

  ngOnInit(): void
  {
    this.initConfig();
    this.getOrdersFromCurrentUser(LocalStorageManager.GetCurrentMail());
  }

  getOrdersFromCurrentUser(email: string)
  {
    this.backendService.getOrdersByEmail(email).subscribe(
      data =>
      {
        console.log(data);
        this.orders = data;

        for (let i = 0; i < data.length; i++) {
          this.totalPrice += data[i].price;
        }

        console.log(this.totalPrice);
      },
      error =>
      {
        console.log(error);
      }
    );
  }


  deleteItem(id: number)
  {
    console.log(id);
    this.backendService.deleteOrder(id, LocalStorageManager.GetCurrentMail().toString()).subscribe(
      data =>
      {
        // console.log(data);
      },
      error =>
      {
        console.log(error);
      }
    );
    this.refreshPage();
  }

  refreshPage()
  {
    setTimeout(() =>
    {
      window.location.reload();
    }, 50);
  }






  private initConfig(): void
  {
    this.payPalConfig = {
      currency: 'EUR',
      clientId: 'sb',
      createOrderOnClient: (data) => <ICreateOrderRequest>{
        intent: 'CAPTURE',
        purchase_units: [
          {
            amount: {
              currency_code: 'EUR',
              value: this.totalPrice.toString(),
            }
          }
        ]
      },
      advanced: {
        commit: 'true'
      },
      style: {
        label: 'paypal',
        layout: 'vertical'
      },
      onApprove: (data, actions) =>
      {
        actions.order.get().then(details =>
        {
        });
      },
      onClientAuthorization: (data) =>
      {
      },
      onCancel: (data, actions) =>
      {
      },
      onError: err =>
      {
        console.log('OnError', err);
      },
      onClick: (data, actions) =>
      {
      },
    };
  }



}