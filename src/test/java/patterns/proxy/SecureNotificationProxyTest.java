package patterns.proxy;

import org.junit.jupiter.api.Test;
import patterns.adapter.NotificationSender;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

class SecureNotificationProxyTest {

    @Test
    void shouldSendNotificationWhenAccessAllowed() {
        NotificationSender sender = mock(NotificationSender.class);
        NotificationSender proxy = new SecureNotificationProxy(sender, true);

        proxy.send("client@example.com", "Test message");

        verify(sender).send("client@example.com", "Test message");
    }

    @Test
    void shouldThrowExceptionWhenAccessDenied() {
        NotificationSender sender = mock(NotificationSender.class);
        NotificationSender proxy = new SecureNotificationProxy(sender, false);

        assertThrows(SecurityException.class, () ->
                proxy.send("client@example.com", "Test message")
        );

        verify(sender, never()).send("client@example.com", "Test message");
    }
}