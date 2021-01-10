package learn.alg.tree;

public class ContainsTopo {

    /**
     * 判断T1树是否包含T2树的
     * @param root
     * @param subRoot
     * @return
     */
    private boolean containsTopo(TreeNode root, TreeNode subRoot) {
        return checkTopo(root, subRoot) || containsTopo(root.left, subRoot)
                || containsTopo(root.right, subRoot);
    }

    private boolean checkTopo(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null || root.value != subRoot.value) {
            return false;
        }
        return checkTopo(root.left, subRoot.left) && checkTopo(root.right, subRoot.right);
    }
}
