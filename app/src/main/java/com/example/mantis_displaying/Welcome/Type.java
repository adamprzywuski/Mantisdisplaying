package com.example.mantis_displaying.Welcome;
import java.util.*;
import java.io.IOException;

public enum Type {
    NOTE;

    public String toValue() {
        switch (this) {
        case NOTE: return "note";
        }
        return null;
    }

    public static Type forValue(String value) throws IOException {
        if (value.equals("note")) return NOTE;
        throw new IOException("Cannot deserialize Type");
    }
}
