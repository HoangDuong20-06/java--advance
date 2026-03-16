package Bai5;

import java.text.DecimalFormat;

public class InvoiceGenerator {

    public void generate(Order order, double total, double finalAmount) {
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println("===== HÓA ĐƠN =====");
        System.out.println("Khách: " + order.getCustomer().getName());
        System.out.println("Tổng tiền: " + df.format(total));
        System.out.println("Sau giảm giá: " + df.format(finalAmount));
        System.out.println("===================");
    }
}