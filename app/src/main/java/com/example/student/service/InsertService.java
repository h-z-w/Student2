package com.example.student.service;

import com.example.student.entity.Insert;

import java.util.List;

public interface InsertService {
    List<Insert> getAllInserts();
    public void insert(Insert insert);
    void delete(String name);
    void modify(Insert insert);


    void modify(int parseInt);
}
