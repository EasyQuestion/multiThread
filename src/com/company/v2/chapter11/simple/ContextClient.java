package com.company.v2.chapter11.simple;

import java.util.stream.IntStream;

public class ContextClient {

    public static void main(String[] args) {
        IntStream.range(1,5).forEach(i->
            new Thread(new ExecutionTask()).start()
        );
    }
}
