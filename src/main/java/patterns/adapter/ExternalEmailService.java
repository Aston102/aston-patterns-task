package patterns.adapter;

public class ExternalEmailService {
    public void sendEmail(String recipient, String text) {
        System.out.println("Email sent to " + recipient + ": " + text);
    }
}