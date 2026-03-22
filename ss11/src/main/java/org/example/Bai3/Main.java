//Giá trị mà phương thức này trả về là một số nguyên (int), biểu thị số lượng bản ghi (dòng) trong cơ sở dữ liệu bị ảnh hưởng bởi câu lệnh SQL.
//Nếu giá trị trả về > 0: có ít nhất một bản ghi đã được thêm, sửa hoặc xóa suy ra thao tác thành công
//Nếu giá trị trả về = 0: không có bản ghi nào bị ảnh hưởng suy ra câu lệnh không tác động đến dữ liệu
//Dựa vào giá trị trả về của executeUpdate(), ta có thể kiểm tra:
//Nếu kết quả = 0 -> kết luận rằng không có giường nào có mã đó trong hệ thống
//Thông báo: "Mã giường này không tồn tại"
//Nếu kết quả > 0 -> cập nhật thành công
//Thông báo: "Cập nhật thành công"
package org.example.Bai3;
import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Connection conn = DBContext.getConnection();
        if (conn == null) return;

        Scanner sc = new Scanner(System.in);
        BedService service = new BedService();

        System.out.print("Enter ID bed: ");
        int id = sc.nextInt();

        service.updateBedStatus(conn, id);
    }
}