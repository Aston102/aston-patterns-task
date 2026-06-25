package patterns.strategy;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscountStrategyTest {

    @Test
    void shouldApplyRegularDiscount() {
        DiscountStrategy strategy = new RegularDiscountStrategy();

        double result = strategy.applyDiscount(1000);

        assertEquals(950, result);
    }

    @Test
    void shouldApplyVipDiscount() {
        DiscountStrategy strategy = new VipDiscountStrategy();

        double result = strategy.applyDiscount(1000);

        assertEquals(800, result);
    }
}
