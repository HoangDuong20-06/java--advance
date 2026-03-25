package org.example.Bai4.Entity;

import java.util.ArrayList;
import java.util.List;

public class Patiens {
    private int id;
    private String name;
    private List<Service> dsDichVu = new ArrayList<>();
    public Patiens(){}
    public Patiens(int id, String name, List<Service> dsDichVu) {
        this.id = id;
        this.name = name;
        this.dsDichVu = dsDichVu;
    }

    public Patiens(int patientId, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Service> getDsDichVu() {
        return dsDichVu;
    }

    public void setDsDichVu(List<Service> dsDichVu) {
        this.dsDichVu = dsDichVu;
    }
}
