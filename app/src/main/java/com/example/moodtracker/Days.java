package com.example.moodtracker;

public class Days {
    private int color;
    private String nameDay;

    public Days(int color, String nameDay) {
        this.color = color;
        this.nameDay = nameDay;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getNameDay() {
        return nameDay;
    }

    public void setnameDay(String nameDay) {
        this.nameDay = nameDay;
    }
}
