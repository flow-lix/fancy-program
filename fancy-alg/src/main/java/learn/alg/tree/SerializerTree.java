/**
 * @Copyright (c) 2019, Denali System Co., Ltd. All Rights Reserved.
 * Website: www.denalisystem.com | Email: marketing@denalisystem.com
 */
package learn.alg.tree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化二叉树
 */
public class SerializerTree {

    /**
     * 先序遍历序列化
     * @param root 根节点
     */
    private String serializerByPreOrder(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        return root.value + "!" + serializerByPreOrder(root.left) + serializerByPreOrder(root.right);
    }

    private int idx;

    /**
     * 反序列化先序字符串
     * @param treeStr
     */
    private void deserializer(String treeStr) {
        String[] nodes = treeStr.split("!");
        deserializerTree(nodes);
    }

    private TreeNode deserializerTree(String[] nodes) {
        if ("#".equals(nodes[idx])) {
            return null;
        }
        TreeNode newNode = new TreeNode(Integer.parseInt(nodes[idx++]));
        newNode.left = deserializerTree(nodes);
        newNode.right = deserializerTree(nodes);
        return newNode;
    }

    /**
     * 按层序列化
     */
    private String serializerByTier(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        StringBuilder builder = new StringBuilder(root.value + "!");
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            if (node.left != null) {
                builder.append(node.left.value + "!");
                nodeQueue.offer(node.left);
            } else {
                builder.append("#!");
            }
            if (node.right != null) {
                builder.append(node.right.value + "!");
                nodeQueue.offer(node.right);
            } else {
                builder.append("#!");
            }
        }
        return builder.toString();
    }

    /**
     * 按层反序列化
     * @return
     */
    private TreeNode deserializerByTier(String treeStr) {
        String[] treeArray = treeStr.split("!");
        int idx = 0;
        TreeNode head = getNode(treeArray[idx++]);
        if (null == head) {
            return null;
        }
        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.offer(head);
        TreeNode node;
        while (!treeQueue.isEmpty()) {
            node = treeQueue.poll();
            node.left = getNode(treeArray[idx++]);
            node.right = getNode(treeArray[idx++]);
            if (node.left != null) {
                treeQueue.offer(node.left);
            }
            if (node.right != null) {
                treeQueue.offer(node.right);
            }
        }
        return head;
    }

    private TreeNode getNode(String val) {
        return "#".equals(val) ? null : new TreeNode(Integer.parseInt(val));
    }
}
