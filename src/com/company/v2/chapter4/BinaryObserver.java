package com.company.v2.chapter4;

public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Binary value:"+Integer.toBinaryString(subject.getState()));
    }
}
