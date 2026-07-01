package patterns;

import java.math.BigDecimal;

public record Order(String customerEmail, BigDecimal amount, boolean vip) {

    public static OrderBuilder builder() {
        return new OrderBuilder();
    }
}