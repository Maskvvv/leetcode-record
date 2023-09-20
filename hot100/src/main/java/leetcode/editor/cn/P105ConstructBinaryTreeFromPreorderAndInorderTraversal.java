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
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 2082 👎 0


import leetcode.editor.cn.model.TreeNode;

import java.util.Arrays;

//Java：105. 从前序与中序遍历序列构造二叉树
public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return build(preorder, inorder);
        }

        public TreeNode build(int[] preorder, int[] inorder) {
            if (inorder.length == 0) return null;

            int rootValue = preorder[0];
            TreeNode root = new TreeNode(rootValue);

            int rootIndex = 0;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == rootValue) {
                    rootIndex = i;
                }
            }

            int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndex);
            int[] rightInorder = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
            int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + leftInorder.length);
            int[] rightPreorder = Arrays.copyOfRange(preorder, preorder.length - rightInorder.length, preorder.length);
            root.left = buildTree(leftPreorder, leftInorder);
            root.right = buildTree(rightPreorder, rightInorder);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
