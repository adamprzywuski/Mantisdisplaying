package com.example.mantis_displaying.Welcome;
import java.util.*;
import java.io.IOException;

public enum Color {
    C2_DFFF, D2_F5_B0, E3_B7_EB, FCBDBD, FFCD85;

    public String toValue() {
        switch (this) {
        case C2_DFFF: return "#c2dfff";
        case D2_F5_B0: return "#d2f5b0";
        case E3_B7_EB: return "#e3b7eb";
        case FCBDBD: return "#fcbdbd";
        case FFCD85: return "#ffcd85";
        }
        return null;
    }

    public static Color forValue(String value) throws IOException {
        if (value.equals("#c2dfff")) return C2_DFFF;
        if (value.equals("#d2f5b0")) return D2_F5_B0;
        if (value.equals("#e3b7eb")) return E3_B7_EB;
        if (value.equals("#fcbdbd")) return FCBDBD;
        if (value.equals("#ffcd85")) return FFCD85;
        throw new IOException("Cannot deserialize Color");
    }
}
