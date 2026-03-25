package org.example.Bai6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Discharge from hospital");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Enter ID Patiens: ");
                    int id = Integer.parseInt(sc.nextLine());
                    service.printData();
                    service.discharge(id);
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}