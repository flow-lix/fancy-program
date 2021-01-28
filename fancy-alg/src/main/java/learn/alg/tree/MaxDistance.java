package learn.alg.tree;

/**
 * 二叉树节点间的最大距离
 */
public class MaxDistance {

    /**
     * 找到二叉树节点间的最大距离
     */
    private ReturnType getMaxDistance(TreeNode root) {
        if (root == null) {
            return new ReturnType(0, 0);
        }
        ReturnType left = getMaxDistance(root.left);
        ReturnType right = getMaxDistance(root.right);

        int height = Math.max(left.height, right.height) + 1;
        int distance = Math.max(left.distance, right.distance);

        return new ReturnType(height, Math.max(left.height + right.height + 1, distance));
    }

    static class ReturnType {
        int height;
        int distance;

        ReturnType(int height, int distance) {
            this.height = height;
            this.distance = distance;
        }
    }
}
