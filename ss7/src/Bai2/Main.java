package Bai2;

public class Main {

    public static void main(String[] args) {

        double total = 1000000;
        DiscountStrategy percent = new PercentageDiscount(10);
        OrderCalculator calc1 = new OrderCalculator(percent);

        double result1 = calc1.calculate(total);

        System.out.println("Đơn hàng: tổng tiền 1.000.000, áp dụng PercentageDiscount 10%");
        System.out.println("Số tiền sau giảm: " + result1);

        DiscountStrategy fixed = new FixedDiscount(50000);
        OrderCalculator calc2 = new OrderCalculator(fixed);

        double result2 = calc2.calculate(total);

        System.out.println("\nĐơn hàng: tổng tiền 1.000.000, áp dụng FixedDiscount 50.000");
        System.out.println("Số tiền sau giảm: " + result2);

        DiscountStrategy none = new NoDiscount();
        OrderCalculator calc3 = new OrderCalculator(none);
        double result3 = calc3.calculate(total);
        System.out.println("\nĐơn hàng: tổng tiền 1.000.000, áp dụng NoDiscount");
        System.out.println("Số tiền sau giảm: " + result3);

        DiscountStrategy holiday = new HolidayDiscount(15);
        OrderCalculator calc4 = new OrderCalculator(holiday);

        double result4 = calc4.calculate(total);

        System.out.println("\nThêm HolidayDiscount 15% (không sửa code cũ)");
        System.out.println("Số tiền sau giảm: " + result4);

    }
}
