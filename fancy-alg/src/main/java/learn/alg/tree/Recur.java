/**
 * @Copyright (c) 2019, Denali System Co., Ltd. All Rights Reserved.
 * Website: www.denalisystem.com | Email: marketing@denalisystem.com
 */
package learn.alg.tree;

import java.util.Deque;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * 六种方式遍历二叉树
 */
public class Recur {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(Integer.MAX_VALUE);
    }

    /**----------------------------------------先序遍历(中左右)-------------------------------->

    /**
     * 递归
     */
    private void preOrderRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value + " ");
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }

    /**
     * Stack
     */
    public void proOrderWithStack(TreeNode root) {
        Stack<TreeNode> tmpStack = new Stack<>();
        TreeNode node = root;
        tmpStack.push(node);
        while ((node = tmpStack.pop()) != null) {
            System.out.println(node.value + " ");
            tmpStack.push(node.right);
            tmpStack.push(node.left);
        }
    }

    /**----------------------------------------中序遍历(左中右)-------------------------------->

     /**
     * 递归
     */
    public void inOrderRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderRecur(root.left);
        System.out.println(root.value + " ");
        inOrderRecur(root.right);
    }
    /**
     * Stack
     */
    public void inOrderWithStack(TreeNode root) {
        Deque<TreeNode> tmpStack = new ConcurrentLinkedDeque<>();
        TreeNode node = root;
        while (!tmpStack.isEmpty() || node != null) {
            if (node != null) {
                tmpStack.push(node);
                node = node.left;
            } else {
                node = tmpStack.pop();
                System.out.println(node.value + " ");
                node = node.right;
            }
        }
    }

    /**----------------------------------------后序遍历(左右中)-------------------------------->
     * 递归
    */
    public void posOrderRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderRecur(root.left);
        inOrderRecur(root.right);
        System.out.println(root.value + " ");
    }
    /**
     * Stack
     */
    public void posOrderWithStack(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> tmpDeque = new ConcurrentLinkedDeque<>();
        TreeNode lastPop = root;
        TreeNode peek = root;
        tmpDeque.push(peek);
        while (!tmpDeque.isEmpty()) {
            peek = tmpDeque.peek();
            if (peek.left != null && lastPop != peek.left && lastPop != peek.right) {
                tmpDeque.push(peek.left);
            } else if (peek.right != null && lastPop != peek.right) {
                tmpDeque.push(peek.right);
            } else {
                System.out.println(tmpDeque.pop().value + " ");
                lastPop = peek;
            }
        }
    }

    /**
     * 树节点
     */
    static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}
