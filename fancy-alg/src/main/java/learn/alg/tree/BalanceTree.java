package learn.alg.tree;

/**
 * 判断是否是一颗平衡二叉树（左右子节点长度不超过1）
 */
public class BalanceTree {

    private boolean ret;

    private boolean isBanlance(TreeNode root) {
        if (root == null) {
            return true;
        }
        getHeight(root, 1);
        return ret;
    }

    private int getHeight(TreeNode root, int level) {
        if (root == null) {
            return 0;
        }
        int ll = getHeight(root.left, level+1);
        if (!ret) {
            return ll;
        }
        int rl = getHeight(root.right, level+1);
        if (!ret) {
            return rl;
        }
        if (Math.abs(ll - rl) > 1) {
            ret = false;
        }
        return Math.max(ll, rl);
    }
}
