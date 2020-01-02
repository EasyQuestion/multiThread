package com.company.v2.chapter11.complex;

public class ExecutionTask implements Runnable {

    private final QueryFromDBAction queryAction = new QueryFromDBAction();
    private final QueryFromHttpAction httpAction = new QueryFromHttpAction();

    @Override
    public void run() {
        Context context = ActionContext.getInstance().getContext();
        queryAction.execute();
        System.out.println("The name get successful.");
        httpAction.execution();
        System.out.println("The cardId get successful.");

        System.out.println("The name is "+context.getName()+" and cardId is "+context.getCardId());
    }
}
