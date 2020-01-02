package com.company.v2.chapter11.think;

public class ExecutionTask implements Runnable {

    private static ThreadLocal<Context> contextThreadLocal = new ThreadLocal<Context>(){
        @Override
        protected Context initialValue() {
            return new Context();
        }
    };
    private final QueryFromDBAction queryAction = new QueryFromDBAction();
    private final QueryFromHttpAction httpAction = new QueryFromHttpAction();

    @Override
    public void run() {
        Context context = getContext();
        queryAction.execute();
        System.out.println("The name get successful.");
        httpAction.execution();
        System.out.println("The cardId get successful.");

        System.out.println("The name is "+context.getName()+" and cardId is "+context.getCardId());
    }

    public static Context getContext(){
        return contextThreadLocal.get();
    }
}
