package org.example.Bai5;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static Service service = new Service();
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. See emnpty beds");
            System.out.println("2. Receiving patients");
            System.out.println("3. Exit");

            int choice = inputInt("Choose: ");

            switch (choice) {
                case 1:
                    showEmptyBeds();
                    break;
                case 2:
                    admitPatient();
                    break;
                case 3:
                    System.out.println("Exit");
                    System.exit(0);
            }
        }
    }
    private static void showEmptyBeds() {
        service.showEmptyBeds();
    }
    private static void admitPatient() {
        System.out.print("Patiens name: ");
        String name = sc.nextLine();
        int age = inputInt("Age: ");
        int bedId = inputInt("Bed id: ");
        double money = inputDouble("Advance money: ");
        service.admitPatient(name, age, bedId, money);
    }
    private static int inputInt(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Enter a valid number!");
            }
        }
    }
    private static double inputDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Enter a valid number!");
            }
        }
    }
}
