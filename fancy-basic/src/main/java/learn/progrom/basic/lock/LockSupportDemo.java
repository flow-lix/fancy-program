/**
 * @Copyright (c) 2019, Denali System Co., Ltd. All Rights Reserved.
 * Website: www.denalisystem.com | Email: marketing@denalisystem.com
 */
package learn.progrom.basic.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

@Slf4j
public class LockSupportDemo {

    public static void main(String[] args) {
        lockPark();
    }

    private static void lockPark() {
        Thread t = new Thread(() -> {
            log.debug("Sub thread begin...");
            LockSupport.park(new Object());
            log.debug("Sub thread end...");
        });
        t.start();
//        LockSupport.unpark(t);
    }
}
