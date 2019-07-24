package com.example.mantis_displaying;

public class date
{
    int id;
    String summary;
    String description;
    String created_at;
    who reporter;
    who handler;
    who project;
    comments notes[];
    values new_values;

    public date(int id, String summary, String description, String created_at,
                who reporter, who handler, who project, comments[] notes, values new_values) {
        this.id = id;
        this.summary = summary;
        this.description = description;
        this.created_at = created_at;
        this.reporter = reporter;
        this.handler = handler;
        this.project = project;
        this.notes = notes;
        this.new_values = new_values;
    }

    public values getNew_values() {
        return new_values;
    }

    public void setNew_values(values new_values) {
        this.new_values = new_values;
    }


    public comments[] getNotes() {
        return notes;
    }

    public void setNotes(comments[] notes) {
        this.notes = notes;
    }

    public who getProject() {
        return project;
    }

    public void setProject(who project) {
        this.project = project;
    }

    public int getId() {
        return id;
    }

    public who getReporter() {
        return reporter;
    }

    public void setReporter(who reporter) {
        this.reporter = reporter;
    }

    public who getHandler() {
        return handler;
    }

    public void setHandler(who handler) {
        this.handler = handler;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
