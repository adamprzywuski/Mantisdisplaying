package com.example.mantis_displaying.Welcome;

import java.util.*;
import java.io.IOException;

public enum Name {
    FAKTURA, HANDLER, RESOLUTION, SEVERITY, STATUS;

    public String toValue() {
        switch (this) {
        case FAKTURA: return "Faktura";
        case HANDLER: return "handler";
        case RESOLUTION: return "resolution";
        case SEVERITY: return "severity";
        case STATUS: return "status";
        }
        return null;
    }

    public static Name forValue(String value) throws IOException {
        if (value.equals("Faktura")) return FAKTURA;
        if (value.equals("handler")) return HANDLER;
        if (value.equals("resolution")) return RESOLUTION;
        if (value.equals("severity")) return SEVERITY;
        if (value.equals("status")) return STATUS;
        throw new IOException("Cannot deserialize Name");
    }
}
