package com.example.mantis_displaying;

public class pro {
    int id;
    String summary;
    String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public pro(int id, String summary, String description) {
        this.id = id;
        this.summary = summary;
        this.description = description;
    }
}
