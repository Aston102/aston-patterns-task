package patterns.strategy;

public class VipDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.80;
    }
}