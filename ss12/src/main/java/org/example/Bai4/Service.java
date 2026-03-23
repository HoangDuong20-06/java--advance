package org.example.Bai4;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private DAO dao = new DAO();
    public void insert() {
        List<Result> list = new ArrayList<>();
        list.add(new Result(1, 5.6));
        list.add(new Result(2, 6.2));
        dao.insertBatch(list);
    }
}
