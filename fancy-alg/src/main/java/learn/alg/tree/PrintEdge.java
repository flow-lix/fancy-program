package learn.alg.tree;

public class PrintEdge {

    /**
     * 1.从上往下打印每行的最左边
     * 2.打印叶子节点
     * 3.从下往上打印每行和最右边
     */
    private void printEdge1(TreeNode root) {
        int h = getHeight(root);
        TreeNode[][] array = new TreeNode[h][2];
        initArray(root, array, 0);

        for (int i = 0; i < h; i++) {
            System.out.println(array[i][0]);
        }

        printLeafNode(root, array, 0);

        for (int i = h; i >= 0; i--) {
            if (array[i][1] != array[i][0]) {
                System.out.println(array[i][1]);
            }
        }
    }

    private void initArray(TreeNode root, TreeNode[][] array, int h) {
        if (root == null) {
            return;
        }
        if (array[h][0] == null) {
            array[h][0] = root;
        }
        array[h][1] = root;
        initArray(root.left, array, h + 1);
        initArray(root.right, array, h + 1);
    }

    private void printLeafNode(TreeNode root, TreeNode[][] array, int h) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.right != null && root != array[h][0] && root != array[h][1]) {
            System.out.println(root.value + " ");
        }
        printLeafNode(root.left, array, h + 1);
        printLeafNode(root.right, array, h + 1);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
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
