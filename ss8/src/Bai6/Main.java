package Bai6;

import Bai6.factory.MobileFactory;
import Bai6.factory.POSFactory;
import Bai6.factory.SalesChannelFactory;
import Bai6.factory.WebsiteFactory;
import Bai6.service.OrderProcessor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Website");
        System.out.println("2. Mobile");
        System.out.println("3. POS");

        int choice = sc.nextInt();

        SalesChannelFactory factory;

        switch (choice) {
            case 1:
                factory = new WebsiteFactory();
                break;
            case 2:
                factory = new MobileFactory();
                break;
            case 3:
                factory = new POSFactory();
                break;
            default:
                throw new IllegalArgumentException("Sai lựa chọn");
        }

        OrderProcessor processor = new OrderProcessor(factory);

        System.out.print("Nhập tiền: ");
        double amount = sc.nextDouble();

        processor.processOrder(amount);
    }
}
