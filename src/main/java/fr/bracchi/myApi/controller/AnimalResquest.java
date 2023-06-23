package fr.bracchi.myApi.controller;

public class AnimalResquest {
    private String name;
    private String type;
    private int weight;

    public AnimalResquest(String name, String type, int weight) {
        this.name = name;
        this.type = type;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }
}
