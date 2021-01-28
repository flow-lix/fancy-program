/**
 * @Copyright (c) 2019, Denali System Co., Ltd. All Rights Reserved.
 * Website: www.denalisystem.com | Email: marketing@denalisystem.com
 */
package learn.alg.tree;

/**
 * 两个节点的最近公共祖先
 */
public class CommonParentNode {

    private TreeNode getCommonParent(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || root == node1 || root == node2) {
            return root;
        }
        TreeNode left = getCommonParent(root.left, node1, node2);
        TreeNode right = getCommonParent(root.right, node1, node2);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
