package patterns.strategy;


import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscountStrategyTest {

    @Test
    void whenApplyRegularDiscount_thenReturnAmountWithRegularDiscount() {
        DiscountStrategy strategy = new RegularDiscountStrategy();

        BigDecimal result  = strategy.applyDiscount(new BigDecimal("1000"));

        assertEquals(new BigDecimal("950.00"), result);
    }

    @Test
    void whenApplyVipDiscount_thenReturnAmountWithVipDiscount() {
        DiscountStrategy strategy = new VipDiscountStrategy();

        BigDecimal result  = strategy.applyDiscount(new BigDecimal("1000"));

        assertEquals(new BigDecimal("800.00"), result);
    }
}
