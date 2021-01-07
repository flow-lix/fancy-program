/**
 * @Copyright (c) 2019, Denali System Co., Ltd. All Rights Reserved.
 * Website: www.denalisystem.com | Email: marketing@denalisystem.com
 */
package learn.alg.tree;

import org.opencv.core.Mat;

import java.util.Map;

/**
 * 二叉树中的和为某值的最长路径
 */
public class MaxPath {

    private int getMaxLength(TreeNode root, int preSum, int k, int tier, int maxLength, Map<Integer, Integer> floorForSum) {
        if (root == null) {
            return 0;
        }
        preSum += root.value;
        if (!floorForSum.containsKey(preSum)) {
            floorForSum.put(preSum, tier);
        }
        if (floorForSum.containsKey(preSum - k)) {
            maxLength = Math.max(maxLength, tier - floorForSum.get(preSum - k));
        }
        maxLength = getMaxLength(root.left, preSum, k, tier+1, maxLength, floorForSum);
        maxLength = getMaxLength(root.right, preSum, k, tier+1, maxLength, floorForSum);
        if (floorForSum.get(preSum) == tier) {
            floorForSum.remove(preSum);
        }
        return maxLength;
    }

}
