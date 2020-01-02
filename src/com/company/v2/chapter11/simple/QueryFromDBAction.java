package com.company.v2.chapter11.simple;

public class QueryFromDBAction {

    public void execute(Context context){
        try {
            Thread.sleep(1000);
            String name = "Alex";
            context.setName(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
