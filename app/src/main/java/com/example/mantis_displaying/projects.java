package com.example.mantis_displaying;

public class projects {

    private Integer id;
    private String name;
    private String status;
    private String descirption;
    private boolean enabled;
    private String view_state;
    private String access_level;
    private String custom_fields;
    private String version;
    private String subProjects;


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getDescirption() {
        return descirption;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getView_state() {
        return view_state;
    }

    public String getAccess_level() {
        return access_level;
    }

    public String getCustom_fields() {
        return custom_fields;
    }

    public String getVersion() {
        return version;
    }

    public String getSubProjects() {
        return subProjects;
    }

    public projects(Integer id, String name, String status, String descirption, boolean enabled, String
                    view_state, String access_level, String custom_fields, String version, String subProjects)
    {this.id=id;
    this.name=name;
    this.status=status;
    this.descirption=descirption;
    this.enabled=enabled;
    this.view_state=view_state;
    this.access_level=access_level;
    this.custom_fields=custom_fields;
    this.version=version;
    this.subProjects=subProjects;
    }



}
