/**
 * @Copyright (c) 2019, Denali System Co., Ltd. All Rights Reserved.
 * Website: www.denalisystem.com | Email: marketing@denalisystem.com
 */
package learn.progrom.basic.longadder;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.LongAdder;

@Slf4j
public class LongAdderDemo {

    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        longAdder.increment();
        longAdder.add(5);
        longAdder.sum();

        log.info("long : {}", longAdder.longValue());
    }
}
