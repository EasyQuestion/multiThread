package com.company.v2.chapter11.complex;

public class QueryFromDBAction {

    public void execute(){
        try {
            Thread.sleep(1000);
            String name = "Alex";
            ActionContext.getInstance().getContext().setName(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
