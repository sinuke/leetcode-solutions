package com.sinuke.easy;

public class PrintInOrder {

    private int f;

    public PrintInOrder() {
        f = 0;
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();

        f = 1;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while (f != 1) wait();

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();

        f = 2;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while (f != 2) wait();

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}
