/**
 * @Copyright (c) 2019, Denali System Co., Ltd. All Rights Reserved.
 * Website: www.denalisystem.com | Email: marketing@denalisystem.com
 */
package learn.alg.tree;

/**
 * 查找节点的后继节点
 */
public class NextNode {

    private ParentTree getNextNode(ParentTree node) {
        if (null == node) {
            return null;
        }
        // 1. 如果有右子节点，那么下一个节点是右子节点的最左边的节点
        if (node.right != null) {
            ParentTree cur = node.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        } else {
            // 2. 没有右子节点，如果是父节点的左节点，那么就是parent; 3. 没有右子节点，如果是父节点的右节点，向上遍历直到找到第一个是父节点的左节点
            ParentTree parent = node.parent;
            while (parent != null && parent.right == node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    private static class ParentTree {
        public int value;
        public ParentTree left;
        public ParentTree right;
        public ParentTree parent;

        public ParentTree(int value) {
            this.value = value;
        }
    }
}
