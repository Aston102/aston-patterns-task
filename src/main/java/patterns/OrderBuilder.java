package patterns;

public class OrderBuilder {
    private String customerEmail;
    private double amount;
    private boolean vip;

    public OrderBuilder customerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
        return this;
    }

    public OrderBuilder amount(double amount) {
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