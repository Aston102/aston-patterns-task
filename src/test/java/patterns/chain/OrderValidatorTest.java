package patterns.chain;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import patterns.Order;
import patterns.OrderBuilder;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderValidatorTest {

    @Test
    void whenValidateCorrectOrder_thenDoesNotThrowException() {
        Order order = Order.builder()
                .customerEmail("client@example.com")
                .amount(new BigDecimal("1000"))
                .vip(false)
                .build();

        OrderValidator validator = new AmountValidator();
        validator.linkWith(new EmailValidator());

        assertDoesNotThrow(() -> validator.validate(order));
    }

    @Test
    void whenValidateOrderWithInvalidAmount_thenThrowException() {
        Order order = Order.builder()
                .customerEmail("client@example.com")
                .amount(BigDecimal.ZERO)
                .vip(false)
                .build();

        OrderValidator validator = new AmountValidator();
        validator.linkWith(new EmailValidator());

        assertThrows(IllegalArgumentException.class, () -> validator.validate(order));
    }

    @Test
    void whenValidateOrderWithInvalidEmail_thenThrowException() {
        Order order = Order.builder()
                .customerEmail("invalid-email")
                .amount(new BigDecimal("1000"))
                .vip(false)
                .build();

        OrderValidator validator = new AmountValidator();
        validator.linkWith(new EmailValidator());

        assertThrows(IllegalArgumentException.class, () -> validator.validate(order));
    }
}
