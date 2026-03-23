package org.example.Bai2;

public class Service {
    private DAO dao = new DAO();
    public void update() {
        dao.updateVital(1, 37.5, 80);
    }
}
