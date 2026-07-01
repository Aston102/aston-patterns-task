package patterns.strategy;

import java.math.BigDecimal;

public class VipDiscountStrategy implements DiscountStrategy {
    private static final BigDecimal VIP_DISCOUNT_RATE = new BigDecimal("0.80");

    @Override
    public BigDecimal applyDiscount(BigDecimal amount) {

        return amount.multiply(VIP_DISCOUNT_RATE);
    }
}