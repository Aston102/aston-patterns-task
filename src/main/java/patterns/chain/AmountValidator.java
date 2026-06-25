package patterns.chain;

import patterns.Order;

public class AmountValidator extends OrderValidator {
    @Override
    protected void check(Order order) {
        if (order.amount() <= 0) {
            throw new IllegalArgumentException("Order amount must be greater than zero");
        }
    }
}