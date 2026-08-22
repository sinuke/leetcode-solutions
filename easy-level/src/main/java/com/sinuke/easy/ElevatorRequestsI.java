package com.sinuke.easy;

public class ElevatorRequestsI {

    public int elevatorRequests(int n, int[] requests) {
        int r = requests[0];
        for (int i = 1; i < requests.length; i++) {
            r += Math.abs(requests[i - 1] - requests[i]);
        }
        return r;
    }

}
