package com.example.mantis_displaying;

public class projects {

    protected Integer id;
    protected String name;
    protected String descirption;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescirption() {
        return descirption;
    }



    public projects(Integer id, String name, String descirption)
    {this.id=id;
    this.name=name;
    this.descirption=descirption;

    }



}
