package patterns.chain;

import patterns.Order;
import java.math.BigDecimal;

public class AmountValidator extends OrderValidator {
    @Override
    protected void check(Order order) {
        if (order.amount() == null || order.amount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Order amount must be greater than zero");
        }
    }
}