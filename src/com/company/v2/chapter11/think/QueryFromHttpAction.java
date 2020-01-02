package com.company.v2.chapter11.think;

public class QueryFromHttpAction {

    public void execution(){
        try {
            Context context = ExecutionTask.getContext();
            Thread.sleep(1000);
            String name = context.getName();
            String cardId = getByName(name);
            context.setCardId(cardId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getByName(String name) {
        return "124456790"+Thread.currentThread().getId();
    }
}
