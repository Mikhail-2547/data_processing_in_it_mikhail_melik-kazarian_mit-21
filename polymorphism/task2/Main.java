public class Main
{
    public static void main(String[] args) {
        Notification email = new EmailNotification();
        Notification sms = new SMSNotification();
        Notification notification = new Notification();

        notification.send();
        email.send();
        sms.send();
    }
}
