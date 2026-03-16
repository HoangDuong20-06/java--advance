package Bai1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã sản phẩm 1: ");
        String id1 = sc.nextLine();

        System.out.print("Nhập tên sản phẩm 1: ");
        String name1 = sc.nextLine();

        System.out.print("Nhập giá sản phẩm 1: ");
        double price1 = Double.parseDouble(sc.nextLine());

        Product sp1 = new Product(id1, name1, price1);


        System.out.print("Nhập mã sản phẩm 2: ");
        String id2 = sc.nextLine();

        System.out.print("Nhập tên sản phẩm 2: ");
        String name2 = sc.nextLine();

        System.out.print("Nhập giá sản phẩm 2: ");
        double price2 = Double.parseDouble(sc.nextLine());

        Product sp2 = new Product(id2, name2, price2);

        System.out.println("Đã thêm sản phẩm " + id1 + ", " + id2);

        System.out.print("Nhập tên khách hàng: ");
        String customerName = sc.nextLine();

        System.out.print("Nhập email: ");
        String email = sc.nextLine();

        System.out.print("Nhập địa chỉ: ");
        String address = sc.nextLine();

        Customer customer = new Customer(customerName, email, address);

        System.out.println("Đã thêm khách hàng");

        Order order = new Order("ORD001", customer);

        System.out.print("Nhập số lượng " + name1 + ": ");
        int q1 = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập số lượng " + name2 + ": ");
        int q2 = Integer.parseInt(sc.nextLine());

        order.addProduct(sp1, q1);
        order.addProduct(sp2, q2);

        System.out.println("Đơn hàng ORD001 được tạo");

        OrderCaculator calculator = new OrderCaculator();
        double total = calculator.calculateTotal(order);

        System.out.println("Tổng tiền: " + total);


        OrderRepository repo = new OrderRepository();
        repo.save(order);

        EmailService emailService = new EmailService();
        emailService.sendEmail(customer, order.getOrderId());

    }
}