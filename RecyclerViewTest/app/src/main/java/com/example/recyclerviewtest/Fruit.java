package com.example.recyclerviewtest;

public class Fruit {

    private String friutName;

    private int fruitId;

    public Fruit(String name, int imageId) {
        this.friutName = name;
        this.fruitId = imageId;
    }

    public String getName() {
        return friutName;
    }

    public int getImageId() {
        return  fruitId;
    }

}
