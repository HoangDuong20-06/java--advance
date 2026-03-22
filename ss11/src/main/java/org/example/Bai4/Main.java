//Vì điều kiện WHERE luôn đúng, nên câu lệnh SQL sẽ trả về tất cả các bản ghi trong bảng, không còn ý nghĩa lọc theo bed_id ban đầu.
//Đây là hậu quả của việc nối chuỗi trực tiếp dữ liệu đầu vào, dẫn đến lỗi SQL Injection.
package org.example.Bai4;
import java.sql.Connection;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Connection conn = DBContext.getConnection();
        if (conn == null) return;
        Scanner sc = new Scanner(System.in);
        Service service = new Service();
        System.out.println("1. Test SQL Injection");
        System.out.println("2. Safe version");
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        if (choice == 1) {
            service.searchUnsafe(conn, name);
            System.out.println("\nTest: ' OR '1'='1");
        } else {
            service.searchPatientSafe(conn, name);
        }
    }
}
