package com.eldorado.microservico.escaladetrabalho.utils;

public enum DaysOfTheWeek {

    MONDAY("monday"),
    TUESDAY("tuesday"),
    WEDNESDAY("wednesday"),
    THURSDAY("thursday"),
    FRIDAY("friday");

    DaysOfTheWeek(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    private String dayOfTheWeek;

    public String getDayOfTheWeek(){
        return dayOfTheWeek;
    }
}
