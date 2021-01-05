/**
 * @Copyright (c) 2019, Denali System Co., Ltd. All Rights Reserved.
 * Website: www.denalisystem.com | Email: marketing@denalisystem.com
 */
package learn.progrom.basic.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;

/**
 * is
 * @param <E>
 */
@Slf4j
public class ProducerAndConsumer<E> {

    private final Queue<E> queue = new LinkedBlockingQueue<>(1000);

    private NonReentrantLock lock = new NonReentrantLock();

    private final Condition NOT_EMPTY = lock.newCondition();
    private final Condition NOT_FULL = lock.newCondition();

    public void produce(E ele) {
        final NonReentrantLock lock = this.lock;
        try {
            lock.lock();
            while (queue.size() == 1000) {
                NOT_FULL.await();
            }
            queue.offer(ele);
            NOT_EMPTY.signalAll();
        } catch (InterruptedException e) {
            log.error("生产者被中断!", e);
        } finally {
            lock.unlock();
        }
    }

    public void consume() {
        final NonReentrantLock lock = this.lock;
        try {
            lock.lock();
            while (queue.size() == 0) {
                NOT_EMPTY.await();
            }
            NOT_FULL.signalAll();
            queue.poll();
        } catch (InterruptedException e) {
            log.error("消费者被中断!", e);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ProducerAndConsumer pac = new ProducerAndConsumer();
        new Thread(() -> pac.produce("ele")).start();

        new Thread(() -> pac.consume()).start();
    }
}
