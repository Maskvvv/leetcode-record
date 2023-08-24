package leetcode.editor.cn.utils;


import leetcode.editor.cn.model.ListNode;

/**
 * @author zhouhongyin
 * @since 2022/8/22 10:41
 */
public class ListNodeFactory {
    public static ListNode build(int[] nodes) {
        ListNode head = new ListNode();
        for (int i = nodes.length - 1; i >= 0; i--) {
            head.next = new ListNode(nodes[i], head.next);
        }
        return head.next;
    }

}
