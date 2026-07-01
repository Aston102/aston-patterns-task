package patterns.chain;

import patterns.Order;

public abstract class OrderValidator {
    private OrderValidator next;

    public OrderValidator linkWith(OrderValidator next) {
        this.next = next;
        return next;
    }

    public void validate(Order order) {
        check(order);

        if (next != null) {
            next.validate(order);
        }
    }

    protected abstract void check(Order order);
}