package patterns.adapter;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class EmailServiceAdapterTest {

    @Test
    void whenSendNotificationThroughAdapter_thenDoesNotThrowException() {
        ExternalEmailService externalEmailService = new ExternalEmailService();
        NotificationSender sender = new EmailServiceAdapter(externalEmailService);

        assertDoesNotThrow(() ->
                sender.send("client@example.com", "Test message")
        );
    }
}
