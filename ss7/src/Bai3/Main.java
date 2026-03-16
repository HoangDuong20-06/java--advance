package Bai3;

public class Main {

    public static void main(String[] args) {
        PaymentMethod cod = new CODPayment();
        PaymentProcessor processor1 = new PaymentProcessor(cod);
        processor1.process(500000);
        PaymentMethod card = new CreditCardPayment();
        PaymentProcessor processor2 = new PaymentProcessor(card);
        processor2.process(1000000);
        PaymentMethod momo = new MomoPayment();
        PaymentProcessor processor3 = new PaymentProcessor(momo);
        processor3.process(750000);
        PaymentMethod test = new MomoPayment();
        PaymentProcessor processor4 = new PaymentProcessor(test);
        processor4.process(300000);
    }
}