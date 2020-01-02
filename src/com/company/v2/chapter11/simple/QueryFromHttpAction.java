package com.company.v2.chapter11.simple;

public class QueryFromHttpAction {

    public void execution(Context context){
        try {
            Thread.sleep(1000);
            String name = context.getName();
            String cardId = getByName(name);
            context.setCardId(cardId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getByName(String name) {
        return "124456790";
    }
}
