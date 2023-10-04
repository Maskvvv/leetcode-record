package leetcode.editor.cn.utils;


import leetcode.editor.cn.model.ListNode;

/**
 * <p>ListNode Utils</p>
 *
 * @author zhouhongyin
 * @since 2022/8/22 10:41
 */
public class ListNodeUtils {
    public static ListNode build(int[] nodes) {
        ListNode head = new ListNode();
        for (int i = nodes.length - 1; i >= 0; i--) {
            head.next = new ListNode(nodes[i], head.next);
        }
        return head.next;
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }
}
