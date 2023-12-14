package leetcode.editor.cn;
//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
//
//
//
// 示例 1：
//
//
//输入：root = [1,null,2,3]
//输出：[1,3,2]
//
//
// 示例 2：
//
//
//输入：root = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：root = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1986 👎 0

import leetcode.editor.cn.model.TreeNode;
import leetcode.editor.cn.utils.TreeUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//Java：94. 二叉树的中序遍历
public class P94BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P94BinaryTreeInorderTraversal().new Solution();
        // TO TEST

        System.out.println(solution.inorderTraversal(TreeUtils.stringToTreeNode("[1,null,2,3]")));
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

        int WHITE = 0;
        int GRAY = 1;

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;

            Deque<Object[]> stack = new ArrayDeque<>();
            stack.addLast(new Object[]{root, WHITE});

            while (!stack.isEmpty()) {
                Object[] objects = stack.removeLast();
                if (objects[0] == null) continue;

                TreeNode node = (TreeNode) objects[0];
                int color = (int) objects[1];

                if (color == GRAY) {
                    res.add(node.val);
                } else {
                    stack.addLast(new Object[]{node.right, WHITE});
                    stack.addLast(new Object[]{node, GRAY});
                    stack.addLast(new Object[]{node.left, WHITE});
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
