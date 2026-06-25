package patterns.adapter;

public class EmailServiceAdapter implements NotificationSender {
    private final ExternalEmailService externalEmailService;

    public EmailServiceAdapter(ExternalEmailService externalEmailService) {
        this.externalEmailService = externalEmailService;
    }

    @Override
    public void send(String email, String message) {
        externalEmailService.sendEmail(email, message);
    }
}