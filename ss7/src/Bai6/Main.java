package Bai6;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== CHỌN KÊNH BÁN HÀNG =====");
        System.out.println("1. Website");
        System.out.println("2. Mobile App");
        System.out.println("3. Store POS");
        System.out.print("Lựa chọn: ");

        int choice = Integer.parseInt(sc.nextLine());

        SalesChannel channel = null;

        switch (choice) {
            case 1:
                channel = new WebsiteChannel();
                System.out.println("Bạn đã chọn kênh Website");
                break;
            case 2:
                channel = new MobileChannel();
                System.out.println("Bạn đã chọn kênh Mobile App");
                break;
            case 3:
                channel = new POSChannel();
                System.out.println("Bạn đã chọn kênh Store POS");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ");
                return;
        }

        System.out.println("\n===== NHẬP THÔNG TIN SẢN PHẨM =====");

        System.out.print("Tên sản phẩm: ");
        String productName = sc.nextLine();

        System.out.print("Giá sản phẩm: ");
        double price = Double.parseDouble(sc.nextLine());

        System.out.print("Nhập mã giảm giá: ");
        String discountCode = sc.nextLine();

        System.out.println("\n===== THANH TOÁN =====");

        OrderService service = new OrderService();

        service.processOrder(channel, price);

    }
}