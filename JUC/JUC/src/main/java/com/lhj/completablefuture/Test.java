package com.lhj.completablefuture;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

/**
 * @description：
 * @createTime：2023-09-1421:44
 * @author：banyanmei
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(new MyThread2(), executorService);
//                supplyAsync(() -> {
//            System.out.println(Thread.currentThread().getName() + "没有返回值");
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            int result = ThreadLocalRandom.current().nextInt(10);
//            if (result > 0) {
//                //int i = 12 / 0;
//            }
//            return result;
//        }, executorService).whenComplete((v, e) -> {
//            if (e == null) {
//                System.out.println("没有异常");
//            }
//
//        }).exceptionally(e -> {
//            e.printStackTrace();
//            System.out.println("有异常" + e.getMessage() + e.getCause());
//            return null;
//        });
        System.out.println(completableFuture.get());
        System.out.println("main");
        //extracted(executorService);
        //executorService.shutdown();
    }

    static class MyThread implements Runnable {
        @Override
        public void run() {
            System.out.println("come in-----");
        }
    }

    static class MyThread2 implements Supplier<String> {
        @Override
        public String get() {
            System.out.println("come in-----");
            return "hello";
        }
    }


    private static void extracted(ExecutorService executorService) throws InterruptedException, ExecutionException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "有返回值");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "hello";
        }, executorService);
        System.out.println(completableFuture.get());
        System.out.println("main");
        PriorityQueue<Object> objects = new PriorityQueue<>(Comparator.comparingInt(Object::hashCode));
    }
}

