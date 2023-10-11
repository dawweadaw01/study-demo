package com.lhj.TestFutureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description：
 * @createTime：2023-09-1316:55
 * @author：banyanmei
 */
public class TestFutureTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> stringFutureTask = new FutureTask<>(new MyThread());
        new Thread(stringFutureTask,"A").start();
        System.out.println(stringFutureTask.get());

    }
}

class MyThread implements Callable<String> {
    @Override
    public String call() {
        System.out.println("come in-----");
        return "hello";
    }
}
