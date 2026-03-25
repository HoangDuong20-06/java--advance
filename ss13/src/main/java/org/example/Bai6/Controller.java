package org.example.Bai6;

import java.util.Scanner;

public class Controller {
    private Service service = new Service();
    private Scanner sc = new Scanner(System.in);
    public void menu() {
        while (true) {
            System.out.println("1. Discharge from hospital");
            System.out.println("0. Exit");

            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                System.out.print("Enter ID patiens: ");
                int id = Integer.parseInt(sc.nextLine());
                service.discharge(id);
            } else {
                break;
            }
        }
    }
}
