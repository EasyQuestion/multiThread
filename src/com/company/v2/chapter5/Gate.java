package com.company.v2.chapter5;

/**
 * 1.shared resource
 *
 */
public class Gate {

    private int counter = 0;
    private String name = "Nobody";
    private String address = "NoWhere";

    //2.临界值
    public synchronized void pass(String name, String address) {
        this.counter++;
        //3.竞争
        this.name = name;
        this.address = address;
        verify();
    }

    private void verify() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("=====================BROKEN=============" + toString());
        }
    }

    @Override
    public String toString() {
        return "No." + counter + ":" + name + "," + address;
    }


}
