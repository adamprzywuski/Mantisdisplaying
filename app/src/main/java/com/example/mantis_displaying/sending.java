package com.example.mantis_displaying;

public class sending {
    //The class responsible for updating comments after adding a new one
    String text;
    view_state view_state;

    public sending() {
    }

    public sending(String text, com.example.mantis_displaying.view_state view_state) {
        this.text = text;
        this.view_state = view_state;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public com.example.mantis_displaying.view_state getView_state() {
        return view_state;
    }

    public void setView_state(com.example.mantis_displaying.view_state view_state) {
        this.view_state = view_state;
    }

    public String toString()
    {
        return "{ \"text\": \"test note\",\"view_state\": {\"name\": \"public\" } }";
    }
}


