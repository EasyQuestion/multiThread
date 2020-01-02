package com.company.v2.chapter11.think;

public class QueryFromDBAction {

    public void execute(){
        try {
            Thread.sleep(1000);
            String name = "Alex"+Thread.currentThread().getName();
            ExecutionTask.getContext().setName(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
