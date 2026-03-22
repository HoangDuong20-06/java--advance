// Việc khởi tạo kết nối đến cơ sở dữ liệu liên tục ko đóng hoặc ko có cơ chế
// quản lý tập trung sẽ gây rò rỉ kết nối. Mỗi ần hệ thống thức hiện tạo 1 connection mới
// nhừng sau khi sử dụng ko đc giải phóng sẽ dẫn đến số lượng connection tăng dần và khi
// mà số lượng connection vượt quá giới hạn database cho phép sẽ gây lỗi Communications links failure
// Điều này đặc biệt nguy hiểm đối với hệ thống y tế vì hệ thống y tế cần hoạt động 24/7 và
// khi mất kết nối sẽ ko thể truy cập tới hồ sơ bệnh nhân và sẽ gây gián đoạn quá trình khám và điều trị bệnh
package org.example.Bai1;

public class Main {
    public static void main(String[] args) {
        Patient dao = new Patient();
        dao.getAllPatients();
    }
}