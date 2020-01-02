package com.company.v2.chapter12;

public class BalkingClient {

    public static void main(String[] args) {
        BalkingData balkingData = new BalkingData("C:\\IdeaProject\\mmh\\lockDemo\\balking.txt", "=========Begin===========");
        new ConsumerThread(balkingData).start();
        new WaiterThread(balkingData).start();
    }
}
