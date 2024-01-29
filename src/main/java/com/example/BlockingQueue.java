package com.example;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
    Queue<Runnable> arr = new LinkedList<>();
    public void add(Runnable runnable){
        arr.add(runnable);
    }

    public Runnable take(){
        return arr.poll();
    }
}
