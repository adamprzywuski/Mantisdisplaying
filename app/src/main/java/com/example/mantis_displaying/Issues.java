package com.example.mantis_displaying;

import java.util.List;

public class Issues {
    //Its class of Array from data

    List<date> issues;

    public Issues() {
    }

    public Issues(List<date> issues) {
        this.issues = issues;
    }

    public List<date> getIssues() {
        return issues;
    }

    public void setIssues(List<date> issues) {
        this.issues = issues;
    }
}