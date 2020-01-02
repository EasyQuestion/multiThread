package com.company.v2.chapter4;

public class Client {

    public static void main(String[] args) {
        Subject subject = new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);

        System.out.println("+++++++++++++++++++++++++++++++++");
        subject.setState(10);
        System.out.println("+++++++++++++++++++++++++++++++++");
        subject.setState(10);
        System.out.println("+++++++++++++++++++++++++++++++++");
        subject.setState(15);
    }
}
