package com.company.v2.chapter11.complex;

public class QueryFromHttpAction {

    public void execution(){
        try {
            Context context = ActionContext.getInstance().getContext();
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
