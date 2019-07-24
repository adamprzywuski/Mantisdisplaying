package com.example.mantis_displaying;

public class values {
    int id;
    String name;
    String label;
    String color;

    public values(int id, String name, String label, String color) {
        this.id = id;
        this.name = name;
        this.label = label;
        this.color = color;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
