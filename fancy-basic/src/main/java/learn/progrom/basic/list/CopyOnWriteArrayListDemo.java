/**
 * @Copyright (c) 2019, Denali System Co., Ltd. All Rights Reserved.
 * Website: www.denalisystem.com | Email: marketing@denalisystem.com
 */
package learn.progrom.basic.list;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 写时复制；弱一致性；快照
 */
@Slf4j
public class CopyOnWriteArrayListDemo {

    private static CopyOnWriteArrayList<String> copyList = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws Exception {
        weakConsistency();
    }

    private static void weakConsistency() throws InterruptedException {
        copyList.add("今天");
        copyList.add("是个");
        copyList.add("好天气！");
        Thread t = new Thread(() -> {
            copyList.remove(1);
            copyList.remove(1);
        });
        Iterator<String> iterator = copyList.iterator();
        t.start();
        t.join();
        while (iterator.hasNext()) {
            log.info("element: {}", iterator.next());
        }
    }

}
