package leetcode.editor.cn;
//给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。
//
//
//
// 示例 1：
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
//
//
// 示例 2：
//
// 输入：lists = []
//输出：[]
//
//
// 示例 3：
//
// 输入：lists = [[]]
//输出：[]
//
//
//
//
// 提示：
//
//
// k == lists.length
// 0 <= k <= 10^4
// 0 <= lists[i].length <= 500
// -10^4 <= lists[i][j] <= 10^4
// lists[i] 按 升序 排列
// lists[i].length 的总和不超过 10^4
//
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2708 👎 0

import leetcode.editor.cn.model.ListNode;

//Java：23. 合并 K 个升序链表
public class P23MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new P23MergeKSortedLists().new Solution();
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
        public ListNode mergeKLists(ListNode[] lists) {
            return merge(lists, 0, lists.length);

        }

        public ListNode merge(ListNode[] lists, int l, int r) {
            if (l >= r || l < 0 || r > lists.length) {
                return null;
            }
            if (l + 1 == r) {
                return lists[l];
            }
            int mid = l + r >> 1;
            ListNode list1 = merge(lists, l, mid);
            ListNode list2 = merge(lists, mid, r);

            ListNode dummyHead = new ListNode();
            ListNode pre = dummyHead;

            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    pre.next = list1;
                    list1 = list1.next;
                } else {
                    pre.next = list2;
                    list2 = list2.next;
                }

                pre = pre.next;
            }

            if (list1 != null) {
                pre.next = list1;
            }

            if (list2 != null) {
                pre.next = list2;
            }

            return dummyHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
