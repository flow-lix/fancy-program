/**
 * @Copyright (c) 2019, Denali System Co., Ltd. All Rights Reserved.
 * Website: www.denalisystem.com | Email: marketing@denalisystem.com
 */
package learn.alg.tree;

import cn.hutool.core.lang.Assert;

/**
 * 后续数组重建二叉搜索树
 */
public class PosArray {

    public static void main(String[] args) {
        PosArray posArray = new PosArray();
        int[] arr = new int[]{2,1,3,6,5,7,4};

        Assert.isTrue(isPosArray(arr));
    }

    /**
     * 判断后续数组是不是一个二叉搜索树
     */
    private static boolean isPosArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        return isPost(arr, 0, arr.length - 1);
    }

    private static boolean isPost(int[] arr, int start, int end) {
        if (start >= end) {
            return true;
        }
        int compare = arr[end];
        int left = start;
        while (left < end) {
            if (arr[left] > compare) {
                break;
            }
            left++;
        }
        int right = left;
        while (right < end) {
            if (arr[right] <= compare) {
                return false;
            }
            right++;
        }
        return isPost(arr, start, left) && isPost(arr, left + 1, end - 1);
    }

    /**
     * 后续数组重建二叉树
     */
    private TreeNode rebuildTree(int[] arr, int head, int tail) {
        if (head > tail) {
            return null;
        }
        int compare = arr[tail];
        // 划分数组
        TreeNode newNode = new TreeNode(compare);
        int idx = head;
        while (idx < tail) {
            if (arr[idx] > compare) {
                break;
            }
            idx++;
        }
        newNode.left = rebuildTree(arr, head, idx-1);
        newNode.right = rebuildTree(arr, idx, tail-1);
        return newNode;
    }

}
