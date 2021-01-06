/**
 * @Copyright (c) 2019, Denali System Co., Ltd. All Rights Reserved.
 * Website: www.denalisystem.com | Email: marketing@denalisystem.com
 */
package learn.alg.tree;

/**
 * 美观地打印二叉树
 */
public class PrintTree {

    /**
     * 中序遍历
     * @param root
     */
    private void printTree(TreeNode root, int total, int tier, char logo) {
        printTree(root.left, total, tier + 1, '&');
        String val = String.valueOf(root.value);
        int leftSpace = (total - val.length()) / 2;
        int rightSpace = total - val.length() - leftSpace;
        val = getSpace(leftSpace) + val + getSpace(rightSpace);
        System.out.println(tier * total + val);
        printTree(root.right, total, tier + 1, '*');
    }

    private String getSpace(int spaceNum) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < spaceNum; i++) {
            builder.append(" ");
        }
        return builder.toString();
    }
}
