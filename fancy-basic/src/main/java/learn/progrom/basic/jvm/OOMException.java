/**
 * @Copyright (c) 2019, Denali System Co., Ltd. All Rights Reserved.
 * Website: www.denalisystem.com | Email: marketing@denalisystem.com
 */
package learn.progrom.basic.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出异常
 */
public class OOMException {

    public static void main(String[] args) {
        List<StaticObject> list = new ArrayList<>();
        while (true) {
            list.add(new StaticObject());
        }
    }

    static class StaticObject {

    }
}
