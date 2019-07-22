package com.example.mantis_displaying.Welcome;
import java.util.*;

public class Issue {
    private int id;
    private String summary;
    private String description;
    private Category project;
    private Category category;
    private Category reporter;
    private Priority status;
    private Priority resolution;
    private Priority viewState;
    private Priority priority;
    private Priority severity;
    private Priority reproducibility;
    private boolean sticky;
    private String createdAt;
    private String updatedAt;
    private NoteElement[] notes;
    private Category[] monitors;
    private History[] history;
    private Category handler;
    private CustomField[] customFields;
    private String additionalInformation;
    private String platform;
    private String os;
    private String osBuild;
    private Attachment[] attachments;

    public int getID() { return id; }
    public void setID(int value) { this.id = value; }

    public String getSummary() { return summary; }
    public void setSummary(String value) { this.summary = value; }

    public String getDescription() { return description; }
    public void setDescription(String value) { this.description = value; }

    public Category getProject() { return project; }
    public void setProject(Category value) { this.project = value; }

    public Category getCategory() { return category; }
    public void setCategory(Category value) { this.category = value; }

    public Category getReporter() { return reporter; }
    public void setReporter(Category value) { this.reporter = value; }

    public Priority getStatus() { return status; }
    public void setStatus(Priority value) { this.status = value; }

    public Priority getResolution() { return resolution; }
    public void setResolution(Priority value) { this.resolution = value; }

    public Priority getViewState() { return viewState; }
    public void setViewState(Priority value) { this.viewState = value; }

    public Priority getPriority() { return priority; }
    public void setPriority(Priority value) { this.priority = value; }

    public Priority getSeverity() { return severity; }
    public void setSeverity(Priority value) { this.severity = value; }

    public Priority getReproducibility() { return reproducibility; }
    public void setReproducibility(Priority value) { this.reproducibility = value; }

    public boolean getSticky() { return sticky; }
    public void setSticky(boolean value) { this.sticky = value; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String value) { this.createdAt = value; }

    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String value) { this.updatedAt = value; }

    public NoteElement[] getNotes() { return notes; }
    public void setNotes(NoteElement[] value) { this.notes = value; }

    public Category[] getMonitors() { return monitors; }
    public void setMonitors(Category[] value) { this.monitors = value; }

    public History[] getHistory() { return history; }
    public void setHistory(History[] value) { this.history = value; }

    public Category getHandler() { return handler; }
    public void setHandler(Category value) { this.handler = value; }

    public CustomField[] getCustomFields() { return customFields; }
    public void setCustomFields(CustomField[] value) { this.customFields = value; }

    public String getAdditionalInformation() { return additionalInformation; }
    public void setAdditionalInformation(String value) { this.additionalInformation = value; }

    public String getPlatform() { return platform; }
    public void setPlatform(String value) { this.platform = value; }

    public String getOS() { return os; }
    public void setOS(String value) { this.os = value; }

    public String getOSBuild() { return osBuild; }
    public void setOSBuild(String value) { this.osBuild = value; }

    public Attachment[] getAttachments() { return attachments; }
    public void setAttachments(Attachment[] value) { this.attachments = value; }
}
