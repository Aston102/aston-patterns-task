package patterns;

import java.math.BigDecimal;

public class OrderBuilder {
    private String customerEmail;
    private BigDecimal amount;
    private boolean vip;

    public OrderBuilder customerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
        return this;
    }

    public OrderBuilder amount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public OrderBuilder vip(boolean vip) {
        this.vip = vip;
        return this;
    }

    public Order build() {
        return new Order(customerEmail, amount, vip);
    }
}