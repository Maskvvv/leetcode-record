package leetcode.editor.cn;
//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,2,1]
//输出：true
//
//
// 示例 2：
//
//
//输入：head = [1,2]
//输出：false
//
//
//
//
// 提示：
//
//
// 链表中节点数目在范围[1, 10⁵] 内
// 0 <= Node.val <= 9
//
//
//
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
// Related Topics 栈 递归 链表 双指针 👍 1380 👎 0


//Java：回文链表
public class P234PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new P234PalindromeLinkedList().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) return true;

            ListNode slow = head;
            ListNode fast = head;
            ListNode pre = head;
            ListNode prepre = null;

            while (fast != null && fast.next != null) {
                pre = slow;
                slow = slow.next;
                fast = fast.next.next;

                pre.next = prepre;
                prepre = pre;
            }

            // 节点数量为奇数的情况
            if (fast != null) {
                slow = slow.next;
            }

            while (slow != null && pre != null) {
                if (slow.val != pre.val) return false;

                slow = slow.next;
                pre = pre.next;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
