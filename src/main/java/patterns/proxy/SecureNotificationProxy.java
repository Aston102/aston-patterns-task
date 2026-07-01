package patterns.proxy;

import patterns.adapter.NotificationSender;

public class SecureNotificationProxy implements NotificationSender {
    private final NotificationSender sender;
    private final boolean accessAllowed;

    public SecureNotificationProxy(NotificationSender sender, boolean accessAllowed) {
        this.sender = sender;
        this.accessAllowed = accessAllowed;
    }

    @Override
    public void send(String email, String message) {
        if (!accessAllowed) {
            throw new SecurityException("Access denied");
        }

        sender.send(email, message);
    }
}