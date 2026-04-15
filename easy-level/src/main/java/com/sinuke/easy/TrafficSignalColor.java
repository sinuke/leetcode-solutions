package com.sinuke.easy;

public class TrafficSignalColor {

    // 0 ms
    public String trafficSignal(int timer) {
        if (timer == 0) return "Green";
        else if (timer == 30) return "Orange";
        else if (timer > 30 && timer <= 90) return "Red";
        else return "Invalid";
    }

    // 6 ms
//    public String trafficSignal2(int timer) {
//        return switch (timer) {
//            case 0 -> "Green";
//            case 30 -> "Orange";
//            case int i when i > 30 && i <= 90 -> "Red";
//            default -> "Invalid";
//        };
//    }

}
