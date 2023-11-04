package leetcode.editor.cn;
//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
//
//
// 示例 2：
//
//
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
//
//
// 示例 3：
//
//
//输入：head = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内
// -10⁵ <= Node.val <= 10⁵
//
//
//
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
//
// Related Topics 链表 双指针 分治 排序 归并排序 👍 2150 👎 0

import leetcode.editor.cn.model.ListNode;
import leetcode.editor.cn.utils.ListNodeUtils;

//Java：148. 排序链表
public class P148SortList {
    public static void main(String[] args) {
        Solution solution = new P148SortList().new Solution();
        // TO TEST
        ListNode node = solution.sortList(ListNodeUtils.stringToListNode("[4,2,1,3]"));

        ListNodeUtils.printListNode(node);
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
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) return head;

            return sort(head);
        }

        public ListNode sort(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode slow = head;
            ListNode fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode node1 = sort(slow.next);
            slow.next = null;
            ListNode node2 = sort(head);

            ListNode dummyHead = new ListNode();
            ListNode pre = dummyHead;

            while (node1 != null && node2 != null) {
                if (node1.val < node2.val) {
                    pre.next = node1;

                    pre = pre.next;
                    node1 = node1.next;
                } else {
                    pre.next = node2;

                    pre = pre.next;
                    node2 = node2.next;
                }
            }

            if (node1 != null) {
                pre.next = node1;
            }

            if (node2 != null) {
                pre.next = node2;
            }

            return dummyHead.next;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
