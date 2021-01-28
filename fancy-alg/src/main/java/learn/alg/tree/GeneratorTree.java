/**
 * @Copyright (c) 2019, Denali System Co., Ltd. All Rights Reserved.
 * Website: www.denalisystem.com | Email: marketing@denalisystem.com
 */
package learn.alg.tree;

/**
 * 有序数组生成二叉搜索平衡树
 */
public class GeneratorTree {

    private TreeNode generatorTree(int[] sortedArray) {
        if (sortedArray == null || sortedArray.length == 0) {
            return null;
        }
        return generatorTree(sortedArray, 0, sortedArray.length);
    }

    private TreeNode generatorTree(int[] sortedArray, int start, int end) {
        if (start > end) {
            return null;
        }
        int idx = start + (end - start) / 2;
        TreeNode head = new TreeNode(sortedArray[idx]);

        head.left = generatorTree(sortedArray, 0, idx - 1);
        head.right = generatorTree(sortedArray, idx + 1, end);
        return head;
    }
}
