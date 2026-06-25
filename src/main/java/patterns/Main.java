package patterns;

import patterns.adapter.EmailServiceAdapter;
import patterns.adapter.ExternalEmailService;
import patterns.adapter.NotificationSender;
import patterns.chain.AmountValidator;
import patterns.chain.EmailValidator;
import patterns.chain.OrderValidator;
import patterns.decorator.LoggingNotificationDecorator;
import patterns.proxy.SecureNotificationProxy;
import patterns.strategy.DiscountStrategy;
import patterns.strategy.RegularDiscountStrategy;
import patterns.strategy.VipDiscountStrategy;

public class Main {
    public static void main(String[] args) {
        Order order = new OrderBuilder()
                .customerEmail("client@example.com")
                .amount(1000)
                .vip(true)
                .build();

        OrderValidator validator = new AmountValidator();
        validator.linkWith(new EmailValidator());
        validator.validate(order);

        DiscountStrategy discountStrategy = order.vip()
                ? new VipDiscountStrategy()
                : new RegularDiscountStrategy();

        double finalAmount = discountStrategy.applyDiscount(order.amount());

        NotificationSender sender = new EmailServiceAdapter(new ExternalEmailService());
        sender = new LoggingNotificationDecorator(sender);
        sender = new SecureNotificationProxy(sender, true);

        sender.send(
                order.customerEmail(),
                "Your final order amount is: " + finalAmount
        );
    }
}