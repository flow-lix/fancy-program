package learn.alg.tree;

import org.opencv.core.Mat;
import sun.reflect.generics.tree.Tree;

/**
 * 最大平衡搜索树
 */
public class MaxBST {

    private TreeNode getMaxBST(TreeNode root) {
        SubTreeRet ret = process(root);
        return ret.getHead();
    }

    /**
     * 树形dp，后序遍历
     */
    private SubTreeRet process(TreeNode root) {
        if (root == null) {
            return new SubTreeRet(root, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        SubTreeRet leftRet = process(root.left);
        SubTreeRet rightRet = process(root.right);
        int maxNodes;
        TreeNode head;
        if (leftRet.maxNodes > rightRet.maxNodes) {
            maxNodes = leftRet.maxNodes;
            head = leftRet.head;
        } else {
            maxNodes = rightRet.maxNodes;
            head = rightRet.head;
        }
        int min = Math.min(root.value, Math.min(leftRet.min, rightRet.min));
        int max = Math.max(root.value, Math.max(leftRet.max, rightRet.max));
        // 第三种情况
        if (root.left == leftRet.head &&  root.right == rightRet.head
                && root.value > leftRet.max && root.value < rightRet.min) {
            maxNodes = maxNodes + 1;
            head = root;
        }

        return new SubTreeRet(head, maxNodes, min, max);
    }

    private static class SubTreeRet {
        // 当前子树的最小节点值
        private int min;
        // 当前子树的最大节点值
        private int max;
        // 最大BST节点数
        private int maxNodes;
        // 最大BST的头节点
        private TreeNode head;

        public SubTreeRet(TreeNode head, int maxNodes, int min, int max) {
            this.min = min;
            this.max = max;
            this.maxNodes = maxNodes;
            this.head = head;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getMaxNodes() {
            return maxNodes;
        }

        public void setMaxNodes(int maxNodes) {
            this.maxNodes = maxNodes;
        }

        public TreeNode getHead() {
            return head;
        }

        public void setHead(TreeNode head) {
            this.head = head;
        }
    }
}
