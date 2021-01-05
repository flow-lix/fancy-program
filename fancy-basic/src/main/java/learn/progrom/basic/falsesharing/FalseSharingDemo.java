/**
 * @Copyright (c) 2019, Denali System Co., Ltd. All Rights Reserved.
 * Website: www.denalisystem.com | Email: marketing@denalisystem.com
 */
package learn.progrom.basic.falsesharing;

public class FalseSharingDemo {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        slowCycle();
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        fastCycle();
        System.out.println(System.currentTimeMillis() - start);
    }

    private static void slowCycle() {
        int[][] cache = new int [10000][10000];
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                cache[j][i] = 2*i+j;
            }
        }
    }

    private static void fastCycle() {
        int[][] cache = new int [10000][10000];
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                cache[i][j] = 2*i+j;
            }
        }
    }

    @sun.misc.Contended
    static class FalseSharing {
        private long value;

    }
}
