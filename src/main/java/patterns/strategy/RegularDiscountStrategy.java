package patterns.strategy;

import java.math.BigDecimal;

public class RegularDiscountStrategy implements DiscountStrategy {
    private static final BigDecimal REGULAR_DISCOUNT_RATE = new BigDecimal("0.95");

    @Override
    public BigDecimal applyDiscount(BigDecimal amount) {

        return amount.multiply(REGULAR_DISCOUNT_RATE);
    }
}