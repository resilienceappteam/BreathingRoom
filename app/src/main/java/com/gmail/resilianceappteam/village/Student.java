package com.gmail.resilianceappteam.village;

/**
 * Created by callie on 3/30/18.
 */

class Student {

    private String name;
    private int color;
    private int tally;

    public Student(String name, int color, int tally){
        this.name = name;
        this.color = color;
        this.tally = tally;
    }

    public Student(){}

    public int getTally() {
        return tally;
    }

    public void setTally(int tally) {
        this.tally = tally;
    }

    public int getColor() {

        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }


}
