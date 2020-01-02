package com.company.v2.chapter5;

public class Client {

    public static void main(String[] args) {
        Gate gate = new Gate();
        User bj = new User("baobao","beijing",gate);
        User sh = new User("shanglao","shanghai",gate);
        User gz = new User("guanglao","guangzhou",gate);

        bj.start();
        sh.start();
        gz.start();
    }
}
