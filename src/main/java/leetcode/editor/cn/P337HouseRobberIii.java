package leetcode.editor.cn;
//小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
//
// 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接
//相连的房子在同一天晚上被打劫 ，房屋将自动报警。
//
// 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
//
//
//
// 示例 1:
//
//
//
//
//输入: root = [3,2,3,null,3,null,1]
//输出: 7
//解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
//
// 示例 2:
//
//
//
//
//输入: root = [3,4,5,1,3,null,1]
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
//
//
//
//
// 提示：
//
//
//
//
// 树的节点数在 [1, 10⁴] 范围内
// 0 <= Node.val <= 10⁴
//
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1292 👎 0


import java.util.HashMap;
import java.util.Map;

//Java：打家劫舍 III
public class P337HouseRobberIii {
    public static void main(String[] args) {
        Solution solution = new P337HouseRobberIii().new Solution();
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
        Map<TreeNode, Integer> map = new HashMap<>();
        public int rob(TreeNode root) {

            return dfs(root);
        }

        public int dfs(TreeNode root) {
            if (root == null) return 0;
            if (map.containsKey(root)) return map.get(root);

            int res = root.val;

            if (root.left != null) {
                res += dfs(root.left.left) + dfs(root.left.right);
            }

            if (root.right != null) {
                res += dfs(root.right.left) + dfs(root.right.right);
            }
            res = Math.max(res, dfs(root.left) + dfs(root.right));
            map.put(root, res);

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
