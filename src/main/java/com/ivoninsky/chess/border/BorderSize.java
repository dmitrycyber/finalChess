package com.ivoninsky.chess.border;

public class BorderSize {
    private static double AC = 600;
    private static double RC = AC / 8;

    public static double getAC() {
        return AC;
    }

    public static double getRC() {
        return RC;
    }

    public static void setAC(double AC) {
        BorderSize.AC = AC;
    }

    public static void setRC(double RC) {
        BorderSize.RC = RC;
    }
}
