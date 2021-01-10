package learn.alg.tree;

import java.util.Stack;

public class TwoErrorNodes {

    public int[] getTwoErrorNodes(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        int[] errors = new int[2];
        while (stack != null || root != null) {
            if (root != null) {
                stack.push(root.left);
                root = root.left;
            } else {
                root = stack.pop();
                if (pre != null && pre.value > root.value) {
                    errors[0] = errors[0] != 0 ? errors[0] : pre.value;
                    errors[1] = root.value;
                }
                root = root.right;
                pre = root;
            }
        }
        return errors;
    }

    private void getTwoErrorNodes(TreeNode root, TreeNode pre, int[] errors) {
        if (root == null) {
            return;
        }
        getTwoErrorNodes(root.left, root, errors);
        if (pre != null && pre.value > root.value) {
            errors[0] = errors[0] != 0 ? errors[0] : pre.value;
            errors[1] = root.value;
        }
        getTwoErrorNodes(root.right, root, errors);
    }

}