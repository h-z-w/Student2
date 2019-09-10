package com.example.student.service;

import android.content.Context;

import com.example.student.dao.InsertDao;
import com.example.student.dao.InsertDaoImpl;
import com.example.student.entity.Insert;

import java.util.List;

public class InsertServiceImpl implements InsertService{
    private InsertDao insertDao;

    public InsertServiceImpl(Context context) {
        insertDao = new InsertDaoImpl(context);
    }

    @Override
    public List<Insert> getAllInserts() {
        return insertDao.selectAll();
    }


    public void insert(Insert insert) {
        insertDao.insert(insert);
    }

    @Override
    public void delete(String name) {
        insertDao.delete(String.valueOf(name));
    }

    public void modify(Insert insert) {
        insertDao.update(insert);
    }

    @Override
    public void modify(int parseInt) {

    }
}
