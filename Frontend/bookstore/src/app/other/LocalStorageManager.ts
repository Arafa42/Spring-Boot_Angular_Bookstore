export class LocalStorageManager
{
    private static CurrentEmail: string = "";
    private static totalAmountOfOrders: string = "";
    private static totalPriceOfOrders: string = "";



    static SetCurrentMail(email: string)
    {
        this.CurrentEmail = email;
        localStorage.setItem('userEmail', this.CurrentEmail);
    }

    static GetCurrentMail()
    {
        var userMail = localStorage.getItem('userEmail');
        if (userMail == null) {
            this.CurrentEmail = "";
        }
        else {
            this.CurrentEmail = userMail;
        }
        return this.CurrentEmail;
    }



    static SetTotalAmountOfOrders(totalAmount: string)
    {
        this.totalAmountOfOrders = totalAmount;
        localStorage.setItem('totalAmountOfOrders', this.totalAmountOfOrders);
    }

    static GetTotalAmountOfOrders()
    {
        var totalAmount = localStorage.getItem('totalAmountOfOrders');
        if (totalAmount == null) {
            this.totalAmountOfOrders = "";
        }
        else {
            this.totalAmountOfOrders = totalAmount;
        }
        return this.totalAmountOfOrders;
    }


    static SetTotalPriceOfOrders(totalPrice: string)
    {
        this.totalPriceOfOrders = totalPrice;
        localStorage.setItem('totalPriceOfOrders', this.totalPriceOfOrders);
    }

    static GetTotalPriceOfOrders()
    {
        var totalPrice = localStorage.getItem('totalPriceOfOrders');
        if (totalPrice == null) {
            this.totalPriceOfOrders = "";
        }
        else {
            this.totalPriceOfOrders = totalPrice;
        }
        return this.totalPriceOfOrders;
    }


}