package learn.alg.dynamicrecur;

/**
 * 斐波那契数列
 */
public class FibonacciSequence {

    public static void main(String[] args) {
        System.out.println(new FibonacciSequence().getF1(6));
        System.out.println(new FibonacciSequence().getAliveCows(6));
    }

    /**
     * 1 1 2 3 5 8
     * 1 2 3 4 5 6
     */
    public int getF1(int n) {
        if (n <= 2) {
            return 1;
        }
        int tmp = 1;
        int res = 1;
        int pre;
        for (int i = 3; i <= n; i++) {
            pre = res;
            res += tmp;
            tmp = pre;
        }
        return res;
    }

    /**
     * 台阶的多少种走法 f(n) = f(n-1) + f(n-2)
     */
    public int getTheSteps(int n) {
        if (n == 1) {
            return n;
        }
        int p;
        int q = 2;
        int r = 2;
        for (int i = 3; i <= n; i++) {
            p = r;
            r += q;
            q = p;
        }
        return r;
    }

    /**
     * 第n年有多少牛
     * f(n) = f(n-1) + f(n-3)
     */
    public int getAliveCows(int n) {
        if (n <= 3) {
            return n;
        }
        int r1 = 1;
        int r2 = 2;
        int r3 = 3;
        int tmp;
        for (int i = 4; i <= n; i++) {
            tmp = r3;
            r3 += r1;
            r1 = r2;
            r2 = tmp;
        }
        return r3;
    }

}
