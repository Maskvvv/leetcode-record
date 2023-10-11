package leetcode.editor.cn;


import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * <p>String match Algorithm</p>
 *
 * @author zhouhongyin
 * @since 2023/10/10 21:50
 */
public class StringMatchAlgorithm {

    public static int kmp(String masterString, String subString) {

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

    static final int ASCII_SIZE = 126;

    public static int sunday(String s, String pattern) {
        char[] total = s.toCharArray(), part = pattern.toCharArray();
        int tSize = total.length;
        int pSize = part.length;
        int[] move = new int[ASCII_SIZE];
        //主串参与匹配最末位字符移动到该位需要移动的位数
        for (int i = 0; i < ASCII_SIZE; i++) {
            move[i] = pSize + 1;
        }

        for (int i = 0; i < pSize; i++) {
            move[part[i]] = pSize - i;
        }

        int i = 0;//模式串头部在字符串位置

        int j;//模式串已经匹配了的长度

        while (i <= tSize - pSize) {//到达末尾之前
            j = 0;
            while (total[i + j] == part[j]) {
                j++;
                if (j >= pSize) {
                    return i;
                }
            }
            i += move[total[i + pSize]];
        }
        return -1;
    }

    public static void main(String[] args) {
        String master = "sadbutsadlajsdflkajdflkajsdflajsakalkdjflasjdflaoizhouhongyiwsjdflkajsdlfasdjflkajsdoaldjfaloijfoasdoifasd;lksdlkjfalkflajfasdjoi;sjdifalkdgwhrghsahfglzhouhongyiajflkajdfoiasofawjfzhouhongyin";
        String sub = "zhouhongyin";

        StopWatch stopWatch = new StopWatch();
        // 开始时间
        stopWatch.start();
        // 执行时间（1s）
        for (int i = 0; i < 10; i++) {
            //StringMatchAlgorithm.kmp(master, sub);
            StringMatchAlgorithm.sunday(master, sub);
            //master.indexOf(sub);
        }
        // 结束时间
        stopWatch.stop();


        // 统计执行时间（秒）
        System.out.println("执行时长：" + stopWatch.getTime(TimeUnit.SECONDS) + " 秒.");
        // 统计执行时间（毫秒）
        System.out.println("执行时长：" + stopWatch.getTime(TimeUnit.MILLISECONDS) + " 毫秒.");
        // 统计执行时间（纳秒）
        System.out.println("执行时长：" + stopWatch.getTime(TimeUnit.NANOSECONDS) + " 纳秒.");

    }
}
