//Trùng ID -> SQLIntegrityConstraintViolationException
//Nhập chữ vào số -> InputMismatchException
//Chuyên khoa quá dài -> lỗi DB VARCHAR
package org.example.Bai5;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoctorService service = new DoctorService();
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Show list doctor");
            System.out.println("2. Add doctor");
            System.out.println("3. Specialized statistics");
            System.out.println("4. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    service.showDoctors();
                    break;
                case 2:
                    try {
                        System.out.print("ID: ");
                        int id = sc.nextInt(); sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Specialties: ");
                        String sp = sc.nextLine();
                        service.addDoctor(new Doctor(id, name, sp));
                    } catch (Exception e) {
                        System.out.println("Data entry error!");
                    }
                    break;
                case 3:
                    service.statistic();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
