package com.example.mantis_displaying.Welcome;
import java.util.*;
import java.io.IOException;

public enum Label {
    FAKTURA, PRZYPISANY_DO, ROZWIZANIE, STATUS, WANO;

    public String toValue() {
        switch (this) {
        case FAKTURA: return "Faktura";
        case PRZYPISANY_DO: return "Przypisany do";
        case ROZWIZANIE: return "Rozwi\u0105zanie";
        case STATUS: return "Status";
        case WANO: return "Wa\u017cno\u015b\u0107";
        }
        return null;
    }

    public static Label forValue(String value) throws IOException {
        if (value.equals("Faktura")) return FAKTURA;
        if (value.equals("Przypisany do")) return PRZYPISANY_DO;
        if (value.equals("Rozwi\u0105zanie")) return ROZWIZANIE;
        if (value.equals("Status")) return STATUS;
        if (value.equals("Wa\u017cno\u015b\u0107")) return WANO;
        throw new IOException("Cannot deserialize Label");
    }
}
