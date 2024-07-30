public interface Notifier {
    void send();
}

public class EmailNotifier implements Notifier {

    public void send() {
        System.out.println("Sending notification via email...");

    }
}

public abstract class NotifierDecorator implements Notifier {
    protected Notifier decoratedNotifier;

    public NotifierDecorator(Notifier decoratedNotifier) {
        this.decoratedNotifier = decoratedNotifier;
    }
}
public class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier decoratedNotifier) {
        super(decoratedNotifier);
    }

    public void send() {
        decoratedNotifier.send(); // Call the original send method
        System.out.println("Sending notification via SMS...");
    }
}

public class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier decoratedNotifier) {
        super(decoratedNotifier);
    }
public void send() {
        decoratedNotifier.send(); // Call the original send method
        System.out.println("Sending notification via Slack...");
    }
}

public class NotificationTest {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        Notifier smsAndEmailNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackAndEmailNotifier = new SlackNotifierDecorator(emailNotifier);

        smsAndEmailNotifier.send();
        slackAndEmailNotifier.send();
    }
}
