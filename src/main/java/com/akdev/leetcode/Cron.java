package com.akdev.leetcode;

import java.util.Timer;
import java.util.TimerTask;

public class Cron {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("Hello World");
            }
        };
        long delay = 0;
        long intervalPeriod = 1000; //milliSecond 1000 = 1 sec
        timer.scheduleAtFixedRate(task, delay, intervalPeriod);
    }
}
