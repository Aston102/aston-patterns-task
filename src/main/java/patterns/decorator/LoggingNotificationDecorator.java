package patterns.decorator;

import patterns.adapter.NotificationSender;

public class LoggingNotificationDecorator implements NotificationSender {
    private final NotificationSender sender;

    public LoggingNotificationDecorator(NotificationSender sender) {
        this.sender = sender;
    }

    @Override
    public void send(String email, String message) {
        System.out.println("Log: sending notification to " + email);
        sender.send(email, message);
        System.out.println("Log: notification sent");
    }
}