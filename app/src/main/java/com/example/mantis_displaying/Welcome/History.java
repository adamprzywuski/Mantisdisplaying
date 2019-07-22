package com.example.mantis_displaying.Welcome;
import java.util.*;


import com.example.mantis_displaying.Welcome.*;

public class History {
    private String createdAt;
    private Category user;
    private Category type;
    private String message;
    private Value oldValue;
    private Value newValue;
    private HistoryNote note;
    private Field field;
    private String change;
    private File file;

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String value) { this.createdAt = value; }

    public Category getUser() { return user; }
    public void setUser(Category value) { this.user = value; }

    public Category getType() { return type; }
    public void setType(Category value) { this.type = value; }

    public String getMessage() { return message; }
    public void setMessage(String value) { this.message = value; }

    public Value getOldValue() { return oldValue; }
    public void setOldValue(Value value) { this.oldValue = value; }

    public Value getNewValue() { return newValue; }
    public void setNewValue(Value value) { this.newValue = value; }

    public HistoryNote getNote() { return note; }
    public void setNote(HistoryNote value) { this.note = value; }

    public Field getField() { return field; }
    public void setField(Field value) { this.field = value; }

    public String getChange() { return change; }
    public void setChange(String value) { this.change = value; }

    public File getFile() { return file; }
    public void setFile(File value) { this.file = value; }
}
