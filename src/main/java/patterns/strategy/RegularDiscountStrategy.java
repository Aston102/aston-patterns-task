package patterns.strategy;

public class RegularDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.95;
    }
}