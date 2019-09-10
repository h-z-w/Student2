package com.example.student.entity;

import java.io.Serializable;

public class Insert implements Serializable {
    public static  final String TBL_Insert ="CREATE TABLE  insert1("+
            "id integer PRIMARY KEY autoincrement ,"+
            "name VARCHAR(100) NOT NULL,"+
            "class_mate VARCHAR(100) NOT NULL,"+
            "age integer NOT NULL )";
    private int id;
    private String name;
    private String class_mate;
    private int age;
public Insert(){

}
    public Insert(int id, String name, String class_mate, int age) {
        this.id = id;
        this.name = name;
        this.class_mate = class_mate;
        this.age = age;
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

    public String getClass_mate() {
        return class_mate;
    }

    public void setClass_mate(String class_mate) {
        this.class_mate = class_mate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Insert{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", class_mate='" + class_mate + '\'' +
                ", age=" + age +
                '}';
    }
}
