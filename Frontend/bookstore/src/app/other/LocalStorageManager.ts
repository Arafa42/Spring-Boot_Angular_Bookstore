export class LocalStorageManager
{
    private static CurrentEmail: string = "";

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
}