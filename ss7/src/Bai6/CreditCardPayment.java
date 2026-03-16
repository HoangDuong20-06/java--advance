package Bai6;

import java.text.DecimalFormat;

public class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println("Thanh toán thẻ tín dụng: " + df.format(amount));
    }
}
