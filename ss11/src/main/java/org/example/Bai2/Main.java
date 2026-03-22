//Cách sử dụng if (rs.next()) chỉ kiểm tra và xử lý một dòng dữ liệu đầu tiên trong ResultSet.
//Điều này là do mỗi lần gọi rs.next() con trỏ sẽ di chuyển đến bản ghi tiếp theo, và if chỉ thực hiện một lần nên không thể duyệt hết danh sách.
//Vì vậy, nếu bảng có nhiều thuốc, chương trình sẽ chỉ in ra 1 thuốc đầu tiên, không đáp ứng yêu cầu “in danh sách”.
//Ngoài ra, nếu bảng không có dữ liệu, rs.next() trả về false ngay từ đầu, khiến chương trình không in ra gì hoặc gây hiểu nhầm là lỗi.
package org.example.Bai2;

public class Main {
    public static void main(String[] args) {
        Pharmacy dao = new Pharmacy();
        dao.getAllMedicines();
    }
}
