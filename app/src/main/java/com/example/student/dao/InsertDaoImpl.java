package com.example.student.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.student.entity.Insert;
import com.example.student.utils.DBUtil;

import java.util.ArrayList;
import java.util.List;

public class InsertDaoImpl implements InsertDao {
    private SQLiteDatabase db;
    private DBUtil helper;
    public InsertDaoImpl(Context context){
        //调用Util类的构造方法时，如发现demo.db不存在会调用omCreate创建
        //若发现demo.db存在，且version的版本与已有的不一致，则调用onUpgrade方法更新
        helper = new DBUtil(context);

    }

    @Override
    public List<Insert> selectAll() {
        List<Insert> inserts =null;
        //1.获取
        db = helper.getReadableDatabase();
        //2.查询
        String sql = "select * from insert1";
        Cursor cursor = db.rawQuery(sql,null);
        //3.处理结果
        if (cursor != null&& cursor.getCount() >0){
            inserts = new ArrayList<>();
            while (cursor.moveToNext()){
                Insert insert = new Insert();
                insert.setId(cursor.getInt(cursor.getColumnIndex("id")));
                insert.setName(cursor.getString(cursor.getColumnIndex("name")));
                insert.setClass_mate(cursor.getString(cursor.getColumnIndex("class_mate")));
                insert.setAge(cursor.getInt(cursor.getColumnIndex("age")));
                inserts.add(insert);
            }
            cursor.close();
        }
        db.close();
        //4.返回
        return inserts;
    }

    @Override
    public void insert(Insert insert) {
        db = helper.getWritableDatabase();
        String sql = "insert into insert1 values(null,?,?,?)";
        db.execSQL(sql,new Object[]{
                insert.getName(),
                insert.getClass_mate(),
                insert.getAge()
        });
        db.close();
    }

    @Override
    public void update(Insert insert) {
        db = helper.getWritableDatabase();
        String sql = "update insert1 set name=?, class_mate=?,age=? where id=?";
        db.execSQL(sql,new Object[]{
                insert.getName(),
                insert.getClass_mate(),
                insert.getAge(),
                insert.getId()});
        db.close();
    }

    @Override
    public void delete(String name) {
        db = helper.getWritableDatabase();
        String sql = "delete from insert1 where name=?";
        db.execSQL(sql,new Object[]{name});
    }
}
