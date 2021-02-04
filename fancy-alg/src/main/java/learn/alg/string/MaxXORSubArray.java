package learn.alg.string;

/**
 * 子数组最大异或和
 */
public class MaxXORSubArray {

    private int getMaxXOR(int arr[]) {
        int max = Integer.MIN_VALUE;

        int[] xorSum = new int[arr.length];
        xorSum[0] = arr[0];
        // 1. 求每个位置的累加异或和
        for (int i = 1; i < arr.length; i++) {
            xorSum[i] = xorSum[i-1] ^ arr[i];
        }
        // 2. 求每个位置的最大异或和 xorSum[i,j] = xorSum[0,i-1] ^ xorSum[0,j]
        for (int j = 0; j < arr.length; j++) {
            // xorSum[j] [0,1,2...j-1,j]
            max = xorSum[j];
            for (int i = 0; i < j; i++) {
                max = Math.max(max, xorSum[i] ^ xorSum[j]);
            }
        }
        return max;
    }
}
