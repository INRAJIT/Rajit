package com.collanomics.android.dummyapplication;

public class User {

    private int id,year,pantone_value;
    private String  name,color;

    public User (int id, int year, int pantone_value, String name, String color){

        this.id= id;
        this.year=year;
        this.pantone_value=pantone_value;
        this.name=name;
        this.color=color;
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public int getPantone_value() {
        return pantone_value;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}
