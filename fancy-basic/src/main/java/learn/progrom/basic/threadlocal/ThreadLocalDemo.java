/**
 * @Copyright (c) 2019, Denali System Co., Ltd. All Rights Reserved.
 * Website: www.denalisystem.com | Email: marketing@denalisystem.com
 */
package learn.progrom.basic.threadlocal;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class ThreadLocalDemo {

    private static ThreadLocal<String> threadLocal1 = ThreadLocal.withInitial(() -> "THREAD-MAIN");
    private static ThreadLocal<String> threadLocal2 = ThreadLocal.withInitial(() -> "THREAD-MAIN");
    private static ThreadLocal<String> threadLocal3 = ThreadLocal.withInitial(() -> "THREAD-MAIN");

    private static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) throws Exception {
        new Thread(() -> threadLocal1.set("THREAD-ONE" + Thread.currentThread().getName()), "Thread-1")
                .start();
        System.out.println(threadLocal1.get());
        new Thread(() -> threadLocal1.set("THREAD-TWO" + Thread.currentThread().getName()), "Thread-1")
                .start();
        System.out.println(threadLocal1.get());

        new Thread(() -> threadLocal2.set("THREAD-ONE" + Thread.currentThread().getName()), "Thread-2")
                .start();
        System.out.println(threadLocal2.get());

        new Thread(() -> threadLocal2.set("THREAD-TWO" + Thread.currentThread().getName()), "Thread-2")
                .start();
        System.out.println(threadLocal2.get());

        new Thread(() -> threadLocal3.set("THREAD-ONE" + Thread.currentThread().getName()), "Thread-3")
                .start();
        System.out.println(threadLocal3.get());
        new Thread(() -> threadLocal3.set("THREAD-TWO" + Thread.currentThread().getName()), "Thread-3")
                .start();
        System.out.println(threadLocal3.get());

        inheritableThreadLocal.set("INHERITABLE-MAIN-THREAD");

        Thread t = new Thread(() -> {
            log.info("get：{}", inheritableThreadLocal.get());
            System.out.println(inheritableThreadLocal.get());
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(inheritableThreadLocal.get());
        });
        inheritableThreadLocal.set("INHERITABLE-SUB-THREAD");
        t.start();
        t.join();

        randomThreadlocal();
    }

    static void randomThreadlocal() throws Exception {
        final ThreadLocalRandom localRandom = ThreadLocalRandom.current();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<?>> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futureList.add(executor.submit(() -> System.out.println(localRandom.nextInt(10))));
        }
        for(Future future : futureList) {
            System.out.println(future.get());
        }
    }

}
