package com.tavisca.workshops.second.simplethreading;

public abstract class Circle implements Runnable {

    int radius;

    public Circle(int radius){
        this.radius = radius;
    }

    protected double area(){
        return 2 * Math.PI * Math.pow(radius, 2);
    }

    protected double circumference(){
        return 2 * Math.PI * radius;
    }
}
