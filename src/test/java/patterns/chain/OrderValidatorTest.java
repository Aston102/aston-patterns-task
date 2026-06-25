package patterns.chain;


import org.junit.jupiter.api.Test;
import patterns.Order;
import patterns.OrderBuilder;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderValidatorTest {

    @Test
    void shouldPassValidationWhenOrderIsValid() {
        Order order = new OrderBuilder()
                .customerEmail("client@example.com")
                .amount(1000)
                .vip(false)
                .build();

        OrderValidator validator = new AmountValidator();
        validator.linkWith(new EmailValidator());

        assertDoesNotThrow(() -> validator.validate(order));
    }

    @Test
    void shouldThrowExceptionWhenAmountIsInvalid() {
        Order order = new OrderBuilder()
                .customerEmail("client@example.com")
                .amount(0)
                .vip(false)
                .build();

        OrderValidator validator = new AmountValidator();
        validator.linkWith(new EmailValidator());

        assertThrows(IllegalArgumentException.class, () -> validator.validate(order));
    }

    @Test
    void shouldThrowExceptionWhenEmailIsInvalid() {
        Order order = new OrderBuilder()
                .customerEmail("invalid-email")
                .amount(1000)
                .vip(false)
                .build();

        OrderValidator validator = new AmountValidator();
        validator.linkWith(new EmailValidator());

        assertThrows(IllegalArgumentException.class, () -> validator.validate(order));
    }
}
