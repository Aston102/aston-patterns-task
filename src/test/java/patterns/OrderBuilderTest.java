package patterns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderBuilderTest {

    @Test
    void shouldBuildOrder() {
        Order order = new OrderBuilder()
                .customerEmail("client@example.com")
                .amount(1000)
                .vip(true)
                .build();

        assertEquals("client@example.com", order.customerEmail());
        assertEquals(1000, order.amount());
        assertTrue(order.vip());
    }
}