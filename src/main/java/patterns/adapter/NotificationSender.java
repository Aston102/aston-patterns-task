package patterns.adapter;

public interface NotificationSender {
    void send(String email, String message);
}