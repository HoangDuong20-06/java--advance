package org.example.Bai6;
import java.sql.Date;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AppointmentService service = new AppointmentService();
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add examination schedule");
            System.out.println("2. Show list");
            System.out.println("3. Delete calendar");
            System.out.println("4. Update");
            System.out.println("5. Show list by id");
            System.out.println("6. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    try {
                        System.out.print("Patiens name: ");
                        String name = sc.nextLine();

                        System.out.print("Day (yyyy-mm-dd): ");
                        Date date = Date.valueOf(sc.nextLine());

                        System.out.print("Doctor name: ");
                        String doctor = sc.nextLine();
                        System.out.print("Status: ");
                        String status = sc.nextLine();

                        service.add(new Appointment(name, date, doctor, status));
                    } catch (Exception e) {
                        System.out.println("Wrong Format day!");
                    }
                    break;
                case 2:
                    service.showAll();
                    break;
                case 3:
                    System.out.print("Enter Id want delete: ");
                    int id = sc.nextInt();
                    service.delete(id);
                    break;
                case 4:
                    try {
                        System.out.print("Enter ID to update: ");
                        id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Patiens Name: ");
                        String name = sc.nextLine();

                        System.out.print("Date (yyyy-mm-dd): ");
                        Date date = Date.valueOf(sc.nextLine());

                        System.out.print("Doctor name:  ");
                        String doctor = sc.nextLine();

                        System.out.print("Status: ");
                        String status = sc.nextLine();
                        Appointment a = new Appointment(name, date, doctor, status);
                        a.setId(id);
                        service.update(a);
                    } catch (Exception e) {
                        System.out.println("Error!");
                    }
                    break;
                case 5:
                    System.out.print("Enter Id to find: ");
                    int idFind = sc.nextInt();
                    service.findById(idFind);
                    break;
                case 6:
                    return;
            }
        }
    }
}
