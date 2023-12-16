package leetcode.editor.cn;
//给定一个非空二叉树的根节点
// root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10⁻⁵ 以内的答案可以被接受。
//
//
//
// 示例 1：
//
//
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：[3.00000,14.50000,11.00000]
//解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
//因此返回 [3, 14.5, 11] 。
//
//
// 示例 2:
//
//
//
//
//输入：root = [3,9,20,15,7]
//输出：[3.00000,14.50000,11.00000]
//
//
//
//
// 提示：
//
//
//
//
//
// 树中节点数量在 [1, 10⁴] 范围内
// -2³¹ <= Node.val <= 2³¹ - 1
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 466 👎 0

import leetcode.editor.cn.model.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//Java：637. 二叉树的层平均值
public class P637AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P637AverageOfLevelsInBinaryTree().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> res = new ArrayList<>();
            if (root == null) return res;

            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                Deque<TreeNode> nextQueue = new ArrayDeque<>();

                double sum = 0;
                int size = queue.size();


                while (!queue.isEmpty()) {
                    TreeNode node = queue.removeLast();
                    sum += node.val;

                    if (node.left != null) {
                        nextQueue.addLast(node.left);
                    }

                    if (node.right != null) {
                        nextQueue.addLast(node.right);
                    }

                }
                res.add(sum / size);
                queue = nextQueue;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
