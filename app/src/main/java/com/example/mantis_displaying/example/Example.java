
package com.example.mantis_displaying.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "summary",
    "description",
    "project",
    "category",
    "reporter",
    "status",
    "resolution",
    "view_state",
    "priority",
    "severity",
    "reproducibility",
    "sticky",
    "created_at",
    "updated_at",
    "custom_fields",
    "history"
})
public class Example {

    @JsonProperty("id")
    private String id;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("description")
    private String description;
    @JsonProperty("project")
    private Project project;
    @JsonProperty("category")
    private Category category;
    @JsonProperty("reporter")
    private Reporter reporter;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("resolution")
    private Resolution resolution;
    @JsonProperty("view_state")
    private ViewState viewState;
    @JsonProperty("priority")
    private Priority priority;
    @JsonProperty("severity")
    private Severity severity;
    @JsonProperty("reproducibility")
    private Reproducibility reproducibility;
    @JsonProperty("sticky")
    private Boolean sticky;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("custom_fields")
    private List<CustomField> customFields = null;
    @JsonProperty("history")
    private List<History> history = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("project")
    public Project getProject() {
        return project;
    }

    @JsonProperty("project")
    public void setProject(Project project) {
        this.project = project;
    }

    @JsonProperty("category")
    public Category getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(Category category) {
        this.category = category;
    }

    @JsonProperty("reporter")
    public Reporter getReporter() {
        return reporter;
    }

    @JsonProperty("reporter")
    public void setReporter(Reporter reporter) {
        this.reporter = reporter;
    }

    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonProperty("resolution")
    public Resolution getResolution() {
        return resolution;
    }

    @JsonProperty("resolution")
    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    @JsonProperty("view_state")
    public ViewState getViewState() {
        return viewState;
    }

    @JsonProperty("view_state")
    public void setViewState(ViewState viewState) {
        this.viewState = viewState;
    }

    @JsonProperty("priority")
    public Priority getPriority() {
        return priority;
    }

    @JsonProperty("priority")
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @JsonProperty("severity")
    public Severity getSeverity() {
        return severity;
    }

    @JsonProperty("severity")
    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    @JsonProperty("reproducibility")
    public Reproducibility getReproducibility() {
        return reproducibility;
    }

    @JsonProperty("reproducibility")
    public void setReproducibility(Reproducibility reproducibility) {
        this.reproducibility = reproducibility;
    }

    @JsonProperty("sticky")
    public Boolean getSticky() {
        return sticky;
    }

    @JsonProperty("sticky")
    public void setSticky(Boolean sticky) {
        this.sticky = sticky;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("custom_fields")
    public List<CustomField> getCustomFields() {
        return customFields;
    }

    @JsonProperty("custom_fields")
    public void setCustomFields(List<CustomField> customFields) {
        this.customFields = customFields;
    }

    @JsonProperty("history")
    public List<History> getHistory() {
        return history;
    }

    @JsonProperty("history")
    public void setHistory(List<History> history) {
        this.history = history;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
