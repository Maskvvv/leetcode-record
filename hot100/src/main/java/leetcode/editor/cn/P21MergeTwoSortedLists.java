package leetcode.editor.cn;
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例 1：
//
//
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
//
//
// 示例 2：
//
//
//输入：l1 = [], l2 = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：l1 = [], l2 = [0]
//输出：[0]
//
//
//
//
// 提示：
//
//
// 两个链表的节点数目范围是 [0, 50]
// -100 <= Node.val <= 100
// l1 和 l2 均按 非递减顺序 排列
//
//
// Related Topics 递归 链表 👍 3331 👎 0

import leetcode.editor.cn.model.ListNode;

//Java：21. 合并两个有序链表
public class P21MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new P21MergeTwoSortedLists().new Solution();
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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) return list2;
            if (list2 == null) return list1;

            ListNode head = new ListNode();
            ListNode pre = head;

            ListNode p1 = list1, p2 = list2;

            while (p1 != null && p2 != null) {
                if (p1.val < p2.val) {
                    pre.next = p1;

                    pre = pre.next;
                    p1 = p1.next;
                } else {
                    pre.next = p2;

                    pre = pre.next;
                    p2 = p2.next;
                }
            }


            while (p1 != null) {
                pre.next = p1;
                pre = pre.next;
                p1 = p1.next;
            }

            while (p2 != null) {
                pre.next = p2;
                pre = pre.next;
                p2 = p2.next;
            }

            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
