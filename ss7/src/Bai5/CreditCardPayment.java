package Bai5;

import java.text.DecimalFormat;

public class CreditCardPayment implements PaymentMethod {
    DecimalFormat df = new DecimalFormat("#,###");
    public void pay(double amount) {
        System.out.println("Thanh toán thẻ: " + df.format(amount));
    }
}
