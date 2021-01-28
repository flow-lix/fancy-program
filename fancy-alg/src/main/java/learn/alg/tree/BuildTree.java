/**
 * @Copyright (c) 2019, Denali System Co., Ltd. All Rights Reserved.
 * Website: www.denalisystem.com | Email: marketing@denalisystem.com
 */
package learn.alg.tree;

import java.util.ArrayList;

/**
 * 先序遍历和中序遍历重建二叉树
 */
public class BuildTree {

    private int[] rebuildTree(int[] preOrder, int inOrder[]) {
        int[] postOrder = new int[preOrder.length];

        int j = postOrder.length - 1;
        for (int i = 0; i < preOrder.length; i++) {
            int head = preOrder[i];
            postOrder[j] = head;
        }
        return postOrder;
    }
}
