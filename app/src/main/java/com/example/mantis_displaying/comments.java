package com.example.mantis_displaying;

public class comments {
    int id;
    who reporter;
    String text;
    String type;
    String created_at;

    public comments(int id, who reporter, String text, String type, String created_at) {
        this.id = id;
        this.reporter = reporter;
        this.text = text;
        this.type = type;
        this.created_at = created_at;
    }

    public comments() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public who getReporter() {
        return reporter;
    }

    public void setReporter(who reporter) {
        this.reporter = reporter;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpdate_at() {
        return created_at;
    }

    public void setUpdate_at(String update_at) {
        this.created_at = update_at;
    }
}
