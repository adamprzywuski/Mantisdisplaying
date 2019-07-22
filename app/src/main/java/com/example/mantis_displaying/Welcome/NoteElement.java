package com.example.mantis_displaying.Welcome;
import java.util.*;

public class NoteElement {
    private long id;
    private Category reporter;
    private String text;
    private Priority viewState;
    private Type type;
    private String createdAt;
    private String updatedAt;

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public Category getReporter() { return reporter; }
    public void setReporter(Category value) { this.reporter = value; }

    public String getText() { return text; }
    public void setText(String value) { this.text = value; }

    public Priority getViewState() { return viewState; }
    public void setViewState(Priority value) { this.viewState = value; }

    public Type getType() { return type; }
    public void setType(Type value) { this.type = value; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String value) { this.createdAt = value; }

    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String value) { this.updatedAt = value; }
}
