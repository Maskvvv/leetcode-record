package leetcode.editor.cn;
//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。
//
//
//
// 示例 1:
//
//
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
//
//
// 示例 2:
//
//
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
//
//
//
//
// 提示:
//
//
// 1 <= preorder.length <= 3000
// inorder.length == preorder.length
// -3000 <= preorder[i], inorder[i] <= 3000
// preorder 和 inorder 均 无重复 元素
// inorder 均出现在 preorder
// preorder 保证 为二叉树的前序遍历序列
// inorder 保证 为二叉树的中序遍历序列
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1566 👎 0


import leetcode.editor.cn.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

//Java：从前序与中序遍历序列构造二叉树
public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        // TO TEST
        solution.buildTree(new int[]{1,2,3}, new int[]{3,2,1});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = inorder.length;
            for (int i = 0; i < n; i++) {
                map.put(inorder[i], i);
            }

            return dfs(preorder, inorder, 0, n - 1, 0, n - 1);

        }

        public TreeNode dfs(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
            if (preorder_left > preorder_right) return null;

            // 前序遍历中的 root 的索引位置
            int pre_root = preorder_left;
            // 中序遍历中的 root 的索引位置
            int in_root = map.get(preorder[preorder_left]);
            // 构建 root 节点
            TreeNode root = new TreeNode(preorder[preorder_left]);

            // 左子树长度
            int left_length = in_root - inorder_left;

            // 构建左子树
            TreeNode left = dfs(preorder, inorder, preorder_left + 1, preorder_left + left_length, inorder_left, in_root - 1);
            // 构建右子树
            TreeNode right = dfs(preorder, inorder, preorder_left + left_length + 1, preorder_right, in_root + 1, inorder_right);

            root.left = left;
            root.right = right;

            return root;
        }
    }



//leetcode submit region end(Prohibit modification and deletion)

}
