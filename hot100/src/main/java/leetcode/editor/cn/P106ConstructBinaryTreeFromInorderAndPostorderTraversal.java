package leetcode.editor.cn;
//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。
//
//
//
// 示例 1:
//
//
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
//
//
// 示例 2:
//
//
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
//
//
//
//
// 提示:
//
//
// 1 <= inorder.length <= 3000
// postorder.length == inorder.length
// -3000 <= inorder[i], postorder[i] <= 3000
// inorder 和 postorder 都由 不同 的值组成
// postorder 中每一个值都在 inorder 中
// inorder 保证是树的中序遍历
// postorder 保证是树的后序遍历
//
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1101 👎 0

import leetcode.editor.cn.model.TreeNode;
import leetcode.editor.cn.utils.ArrayUtils;

import java.util.Arrays;

//Java：106. 从中序与后序遍历序列构造二叉树
public class P106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P106ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        // TO TEST

        solution.buildTree(ArrayUtils.generateNumArray("[1,2]"), ArrayUtils.generateNumArray("[2,1]"));
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {

            return build(inorder, postorder);
        }

        public TreeNode build(int[] inorder, int[] postorder) {
            if (postorder.length == 0) return null;

            int rootValue = postorder[postorder.length - 1];
            TreeNode node = new TreeNode(rootValue);

            if (postorder.length == 1) return node;

            int rootIndex = 0;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == rootValue) {
                    rootIndex = i;
                    break;
                }
            }

            int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndex);
            int[] leftPostorder = Arrays.copyOfRange(postorder, 0, leftInorder.length);
            node.left = buildTree(leftInorder, leftPostorder);

            int[] rightInorder = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
            int[] rightPostorder = Arrays.copyOfRange(postorder, postorder.length - 1 - rightInorder.length, postorder.length - 1);
            node.right = build(rightInorder, rightPostorder);
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
