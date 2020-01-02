package com.company.v2.chapter4;

public abstract class Observer {

    public Subject subject;

    public Observer(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    public abstract void update();
}
