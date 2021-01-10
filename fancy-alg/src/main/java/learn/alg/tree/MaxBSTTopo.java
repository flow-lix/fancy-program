package learn.alg.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 二叉搜索树的最大拓扑结构数
 */
public class MaxBSTTopo {

    private int getMaxTopo(TreeNode root) {
        // 左子树数量
        int leftMax = getMaxTopo(root.left);
        // 右子树数量
        int rightMax = getMaxTopo(root.right);

        Map<TreeNode, Record> recordMap = new HashMap<>();
        // 更新左子树的对root提供的拓扑值
        updateRecord(root.left, root.value, recordMap, true);
        updateRecord(root.right, root.value, recordMap, false);

        Record lr = recordMap.get(root.left);
        Record rr = recordMap.get(root.right);
        // root的数量
        Record rootRecord = new Record(lr.getTotal(), rr.getTotal());
        recordMap.put(root, rootRecord);

        return Math.max(Math.max(leftMax, rightMax), rootRecord.getTotal());
    }

    private int updateRecord(TreeNode node, int rootVal, Map<TreeNode, Record> recordMap, boolean isLeft) {
        if (node == null) {
            return 0;
        }
        Record record = recordMap.get(node);
        if ((isLeft && node.value > rootVal) || (!isLeft && node.value < rootVal)) {
            recordMap.remove(node);
            return record.getTotal();
        }
        int minus = updateRecord(isLeft ? node.right : node.left, rootVal, recordMap, isLeft);
        if (isLeft)  {
            record.r -= minus;
        } else {
            record.l -= minus;
        }
        return minus;
    }

    /**
     * 节点的左右拓扑树记录
     */
    private static class Record {
        private int l;
        private int r;

        Record(int l, int r) {
            this.l = l;
            this.r = r;
        }

        int getTotal() {
            return l + r + 1;
        }
    }
}
