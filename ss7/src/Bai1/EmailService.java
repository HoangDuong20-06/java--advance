package Bai1;

public class EmailService {

    public void sendEmail(Customer customer, String orderId) {

        System.out.println("Đã gửi email đến "
                + customer.getEmail()
                + ": Đơn hàng " + orderId + " đã được tạo");
    }
}
