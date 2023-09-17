package leetcode.editor.cn;
//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
//
//
// 示例 2：
//
//
//输入：root = [1]
//输出：[[1]]
//
//
// 示例 3：
//
//
//输入：root = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [0, 2000] 内
// -1000 <= Node.val <= 1000
//
//
// Related Topics 树 广度优先搜索 二叉树 👍 1803 👎 0


import leetcode.editor.cn.model.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//Java：102. 二叉树的层序遍历
public class P102BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new P102BinaryTreeLevelOrderTraversal().new Solution();
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;

            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.push(root);

            while (!queue.isEmpty()) {
                Deque<TreeNode> subQueue = new ArrayDeque<>();
                List<Integer> subRes = new ArrayList<>();

                while (!queue.isEmpty()) {
                    TreeNode node = queue.poll();
                    subRes.add(node.val);
                    if (node.left != null) subQueue.offer(node.left);
                    if (node.right != null) subQueue.offer(node.right);

                }

                queue = subQueue;
                res.add(subRes);
            }


            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
