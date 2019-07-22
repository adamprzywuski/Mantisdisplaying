package com.example.mantis_displaying.Welcome;
import java.util.*;

public class Attachment {
    private long id;
    private Category reporter;
    private String createdAt;
    private String filename;
    private long size;
    private String contentType;

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public Category getReporter() { return reporter; }
    public void setReporter(Category value) { this.reporter = value; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String value) { this.createdAt = value; }

    public String getFilename() { return filename; }
    public void setFilename(String value) { this.filename = value; }

    public long getSize() { return size; }
    public void setSize(long value) { this.size = value; }

    public String getContentType() { return contentType; }
    public void setContentType(String value) { this.contentType = value; }
}
