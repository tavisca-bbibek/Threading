package com.tavisca.workshops.second.simplethreading;

public class UsingRunnable {
    public static void main(String[] args) {

        int radius = 4;

        Runnable c1 = new Circle(radius) {
            @Override
            public void run() {
                System.out.println(area());
            }
        };

        Runnable c2 = new Circle(radius) {
            @Override
            public void run() {
                System.out.println(circumference());
            }
        };

        c1.run();
        c2.run();
    }
}
