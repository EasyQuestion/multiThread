package com.company.v2.chapter11.simple;

public class ExecutionTask implements Runnable {

    private final QueryFromDBAction queryAction = new QueryFromDBAction();
    private final QueryFromHttpAction httpAction = new QueryFromHttpAction();

    @Override
    public void run() {
        final Context context = new Context();
        queryAction.execute(context);
        System.out.println("The name get successful.");
        httpAction.execution(context);
        System.out.println("The cardId get successful.");

        System.out.println("The name is "+context.getName()+" and cardId is "+context.getCardId());
    }
}
