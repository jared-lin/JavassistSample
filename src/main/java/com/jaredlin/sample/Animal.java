package com.jaredlin.sample;

/**
 * Created by linmq on 2017/7/23.
 */
public class Animal {
    private String name;

    public String getName() {
        return name;
    }

    public Animal setName(String name) {
        this.name = name;
        return this;
    }

    public void run() {
        System.out.println("My name is "+name+",I'm running");
    }

    @Override
    public String toString() {
        return this.name;
    }
}
