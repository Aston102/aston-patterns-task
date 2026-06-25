package patterns.decorator;

import org.junit.jupiter.api.Test;
import patterns.adapter.NotificationSender;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class LoggingNotificationDecoratorTest {

    @Test
    void shouldCallWrappedSender() {
        NotificationSender sender = mock(NotificationSender.class);
        NotificationSender decoratedSender = new LoggingNotificationDecorator(sender);

        decoratedSender.send("client@example.com", "Test message");

        verify(sender).send("client@example.com", "Test message");
    }
}