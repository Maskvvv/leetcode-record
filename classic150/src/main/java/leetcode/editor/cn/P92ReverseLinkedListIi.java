package leetcode.editor.cn;
//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
//
//
// 示例 2：
//
//
//输入：head = [5], left = 1, right = 1
//输出：[5]
//
//
//
//
// 提示：
//
//
// 链表中节点数目为 n
// 1 <= n <= 500
// -500 <= Node.val <= 500
// 1 <= left <= right <= n
//
//
//
//
// 进阶： 你可以使用一趟扫描完成反转吗？
//
// Related Topics 链表 👍 1707 👎 0

import leetcode.editor.cn.model.ListNode;
import leetcode.editor.cn.utils.ListNodeUtils;

//Java：92. 反转链表 II
public class P92ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new P92ReverseLinkedListIi().new Solution();
        // TO TEST
        ListNode res = solution.reverseBetween(ListNodeUtils.stringToListNode("[5]"), 1, 1);

        System.out.println(ListNodeUtils.listNodeToString(res));
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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummyHead = new ListNode();
            dummyHead.next = head;

            ListNode pre = dummyHead;
            ListNode cur = head;
            for (int i = 1; i < left; i++) {
                cur = cur.next;
                pre = pre.next;
            }

            ListNode l = pre;

            for (int i = 0; i < right - left + 1; i++) {
                ListNode next = cur.next;
                cur.next = pre;

                pre = cur;
                cur = next;
            }

            ListNode r = cur;

            l.next.next = r;
            l.next = pre;

            return dummyHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
