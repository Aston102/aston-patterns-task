package patterns.chain;

import patterns.Order;

public class EmailValidator extends OrderValidator {
    private static final String EMAIL_SYMBOL = "@";

    @Override
    protected void check(Order order) {
        if (order.customerEmail() == null || !order.customerEmail().contains(EMAIL_SYMBOL)) {
            throw new IllegalArgumentException("Invalid customer email");
        }
    }
}