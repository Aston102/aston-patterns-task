package patterns;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class OrderBuilderTest {

    @Test
    void whenBuildOrder_thenReturnOrderWithCorrectFields() {
        Order order = Order.builder()
                .customerEmail("client@example.com")
                .amount(new BigDecimal("1000"))
                .vip(true)
                .build();

        assertEquals("client@example.com", order.customerEmail());
        assertEquals(new BigDecimal("1000"), order.amount());
        assertTrue(order.vip());
    }
}