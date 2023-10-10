package leetcode.editor.cn;

/**
 * <p>KMP Algorithm</p>
 *
 * @author zhouhongyin
 * @since 2023/10/10 21:50
 */
public class KMPAlgorithm {

    public static int match(String masterString, String subString) {

        int[] next = getNext(subString);

        char[] mastChars = masterString.toCharArray();
        char[] subChars = subString.toCharArray();

        int i = 0;
        int j = 0;
        while (i < mastChars.length) {
            if (mastChars[i] == subChars[j]) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = next[j - 1];
                }
            }

            if (j == subChars.length) return i - j;
        }

        return -1;
    }

    private static int[] getNext(String subString) {
        char[] chars = subString.toCharArray();
        int[] next = new int[chars.length];

        int i = 1;
        int prefix = 0;
        while (i < chars.length) {
            if (chars[i] == chars[prefix]) {
                prefix++;
                next[i] = prefix;
                i++;
            } else {
                if (prefix == 0) {
                    next[i] = 0;
                    i++;
                } else {
                    prefix = next[prefix - 1];
                }
            }
        }


        return next;
    }

    public static void main(String[] args) {

        System.out.println(KMPAlgorithm.match("sadbutsad", "sad"));

    }
}
