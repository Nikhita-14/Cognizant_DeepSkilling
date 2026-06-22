public class Main {
    public static void main(String[] args) {
        String criticalAlert = "System breach detected!";

        Notifier emailOnly = new EmailNotifier();
        emailOnly.send(criticalAlert);

        Notifier emailAndSMS = new SMSNotifierDecorator(new EmailNotifier());
        emailAndSMS.send(criticalAlert);

        Notifier multiChannelNotifier = new SlackNotifierDecorator(
                new SMSNotifierDecorator(
                        new EmailNotifier()
                )
        );
        multiChannelNotifier.send(criticalAlert);
    }
}