package learn.alg.tree;

import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的按层打印
 */
public class PrintLevel {

    public static void printByLevel(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node;
        int level = 1;
        while (!queue.isEmpty()) {
            String line = "Level " + level + " : ";
            for (int i = 0; i < queue.size(); i++) {
                node = queue.poll();
                line += (node.value + " ");
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            System.out.println(line);
        }
    }

    public static void printByZ(TreeNode root) {
        boolean leftFirst = true;
        if (root == null) {
            return;
        }
        int level = 1;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node;
        while (!queue.isEmpty()) {
            String line = "Level " + level + " : ";
            for (int i = 0; i < queue.size(); i++) {
                // 如果是从左往右打印，那么就先从左边弹出
                node = leftFirst ? queue.pollFirst() : queue.pollLast();
                if (leftFirst) {
                    // 如果是从左往右打印，那么先添加左子节点
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                } else {
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                }
                leftFirst = !leftFirst;
                line += (node.value + " ");
            }
            System.out.println(line);
        }
    }

}