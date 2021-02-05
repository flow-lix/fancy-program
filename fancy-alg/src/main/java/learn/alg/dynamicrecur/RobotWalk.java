package learn.alg.dynamicrecur;

/**
 * 机器人走过的位置
 */
public class RobotWalk {

    private int walk(int n, int m, int k, int p) {
        if (k == 0) {
            return m == p ? 1 : 0;
        }
        if (m == 1) {
            return walk(n, m + 1, k - 1 , p);
        }
        if (m == n - 1) {
            return walk(n, m - 1, k - 1, p);
        }
        return walk(n, m + 1, k - 1, p) + walk(n, m - 1, k - 1, p);
    }
}
