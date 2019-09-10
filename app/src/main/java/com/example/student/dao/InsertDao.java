package com.example.student.dao;

import com.example.student.entity.Insert;

import java.util.List;

public interface InsertDao {
    List<Insert> selectAll();
    void insert(Insert insert);
    void update(Insert insert);
    void delete(String name);
}
