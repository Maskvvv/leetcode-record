package leetcode.editor.cn;
//给定一个二叉树：
//
//
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
//
// 初始状态下，所有 next 指针都被设置为 NULL 。
//
//
//
// 示例 1：
//
//
//输入：root = [1,2,3,4,5,null,7]
//输出：[1,#,2,3,#,4,5,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指
//针连接），'#' 表示每层的末尾。
//
// 示例 2：
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
// 树中的节点数在范围 [0, 6000] 内
// -100 <= Node.val <= 100
//
//
// 进阶：
//
//
// 你只能使用常量级额外空间。
// 使用递归解题也符合要求，本题中递归程序的隐式栈空间不计入额外空间复杂度。
//
//
//
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 链表 二叉树 👍 818 👎 0

import java.util.ArrayDeque;
import java.util.Deque;

//Java：117. 填充每个节点的下一个右侧节点指针 II
public class P117PopulatingNextRightPointersInEachNodeIi {
    public static void main(String[] args) {
        Solution solution = new P117PopulatingNextRightPointersInEachNodeIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

    class Solution {
        public Node connect(Node root) {

            if (root == null) return root;

            Deque<Node> queue = new ArrayDeque<>();
            queue.addLast(root);

            while (!queue.isEmpty()) {
                Deque<Node> nextQueue = new ArrayDeque<>();

                Node pre = queue.removeFirst();
                if (pre.left != null) nextQueue.addLast(pre.left);
                if (pre.right != null) nextQueue.addLast(pre.right);

                while (!queue.isEmpty()) {
                    Node node = queue.removeFirst();
                    pre.next = node;
                    pre = node;

                    if (node.left != null) nextQueue.addLast(node.left);
                    if (node.right != null) nextQueue.addLast(node.right);
                }

                queue = nextQueue;
            }

            return root;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}
