package Bai5;

import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static List<Product> products = new ArrayList<>();
    static List<Customer> customers = new ArrayList<>();
    static List<Order> orders = new ArrayList<>();

    static List<PaymentMethod> paymentMethods = new ArrayList<>();
    static List<DiscountStrategy> discounts = new ArrayList<>();


    public static void main(String[] args) {

        OrderRepository repo = new FileOrderRepository();
        NotificationService notify = new EmailNotification();
        InvoiceGenerator invoice = new InvoiceGenerator();
        OrderService service = new OrderService(repo, notify, invoice);

        // mặc định
        paymentMethods.add(new CODPayment());
        paymentMethods.add(new MomoPayment());
        paymentMethods.add(new CreditCardPayment());

        discounts.add(new PercentageDiscount(10));
        discounts.add(new FixedDiscount(50000));

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Thêm khách hàng");
            System.out.println("3. Tạo đơn hàng");
            System.out.println("4. Xem danh sách đơn");
            System.out.println("5. Tính tổng doanh thu");
            System.out.println("6. Thêm phương thức thanh toán");
            System.out.println("7. Thêm chiến lược giảm giá");
            System.out.println("8. Thoát");

            System.out.print("Chọn: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    addProduct();
                    break;

                case 2:
                    addCustomer();
                    break;

                case 3:
                    createOrder(service);
                    break;

                case 4:
                    viewOrders();
                    break;

                case 5:
                    totalRevenue();
                    break;

                case 6:
                    addPaymentMethod();
                    break;

                case 7:
                    addDiscount();
                    break;

                case 8:
                    System.out.println("Thoát chương trình");
                    return;

                default:
                    System.out.println("Chọn sai!");
            }
        }
    }

    // thêm sản phẩm
    static void addProduct() {

        System.out.print("Mã SP: ");
        String id = sc.nextLine();

        System.out.print("Tên SP: ");
        String name = sc.nextLine();

        System.out.print("Giá: ");
        double price = Double.parseDouble(sc.nextLine());

        System.out.print("Danh mục: ");
        String cate = sc.nextLine();

        products.add(new Product(id, name, price, cate));

        System.out.println("Đã thêm sản phẩm " + id);
    }

    // thêm khách hàng
    static void addCustomer() {

        System.out.print("Tên: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("SĐT: ");
        String phone = sc.nextLine();

        customers.add(new Customer(name, email, phone));

        System.out.println("Đã thêm khách hàng");
    }

    // tạo đơn hàng
    static void createOrder(OrderService service) {

        if (products.isEmpty() || customers.isEmpty()) {
            System.out.println("Cần có sản phẩm và khách hàng trước!");
            return;
        }

        System.out.println("Chọn khách hàng:");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i+1) + ". " + customers.get(i).getName());
        }

        int cIndex = Integer.parseInt(sc.nextLine()) - 1;
        Customer customer = customers.get(cIndex);

        Order order = new Order("ORD" + (orders.size()+1), customer);

        System.out.println("Chọn sản phẩm:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i+1) + ". " + products.get(i).getName());
        }

        int pIndex = Integer.parseInt(sc.nextLine()) - 1;

        System.out.print("Số lượng: ");
        int qty = Integer.parseInt(sc.nextLine());

        order.addItem(products.get(pIndex), qty);


        System.out.println("Chọn giảm giá:");
        for (int i = 0; i < discounts.size(); i++) {
            System.out.println((i+1) + ". " + discounts.get(i).getClass().getSimpleName());
        }

        int dIndex = Integer.parseInt(sc.nextLine()) - 1;
        DiscountStrategy discount = discounts.get(dIndex);


        System.out.println("Chọn thanh toán:");
        for (int i = 0; i < paymentMethods.size(); i++) {
            PaymentMethod pm = paymentMethods.get(i);
            if (pm instanceof GenericPaymentMethod) {
                System.out.println((i+1) + ". " + ((GenericPaymentMethod) pm).getName());
            } else {
                System.out.println((i+1) + ". " + pm.getClass().getSimpleName());
            }
        }

        int payIndex = Integer.parseInt(sc.nextLine()) - 1;
        PaymentMethod payment = paymentMethods.get(payIndex);


        service.processOrder(order, discount, payment);

        orders.add(order);
    }

    // xem đơn hàng
    static void viewOrders() {

        for (Order o : orders) {
            System.out.println(o.getId() + " - " + o.getCustomer().getName() + " - " + o.getTotal());
        }
    }

    // doanh thu
    static void totalRevenue() {

        double total = 0;

        for (Order o : orders) {
            total += o.getTotal();
        }

        System.out.println("Tổng doanh thu: " + total);
    }

    // thêm payment mới (mô phỏng OCP)
    static void addPaymentMethod() {
        System.out.print("Nhập tên phương thức thanh toán mới: ");
        String name = sc.nextLine();
        paymentMethods.add(new GenericPaymentMethod(name));
        System.out.println("Đã thêm phương thức: " + name);
    }

    // thêm discount mới
    static void addDiscount() {

        System.out.print("Nhập % giảm giá: ");
        double percent = Double.parseDouble(sc.nextLine());

        DiscountStrategy discount = new PercentageDiscount(percent);

        discounts.add(discount);

        System.out.println("Đã thêm giảm giá " + percent + "%");
    }
}