package com.company.v2.chapter11.complex;

public final class ActionContext {

    public static final ThreadLocal<Context> context = new ThreadLocal<Context>(){
        @Override
        protected Context initialValue() {
            return new Context();
        }
    };

    private ActionContext(){

    }

    private static class ContextHolder{
        public static final ActionContext context = new ActionContext();
    }

    public static ActionContext getInstance(){
        return ContextHolder.context;
    }

    public Context getContext(){
        return context.get();
    }
}
