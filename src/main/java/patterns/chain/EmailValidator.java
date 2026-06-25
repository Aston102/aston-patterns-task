package patterns.chain;

import patterns.Order;

public class EmailValidator extends OrderValidator {
    @Override
    protected void check(Order order) {
        if (order.customerEmail() == null || !order.customerEmail().contains("@")) {
            throw new IllegalArgumentException("Invalid customer email");
        }
    }
}