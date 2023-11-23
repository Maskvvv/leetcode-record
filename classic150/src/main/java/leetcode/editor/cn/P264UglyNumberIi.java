package leetcode.editor.cn;
//给你一个整数 n ，请你找出并返回第 n 个 丑数 。
//
// 丑数 就是质因子只包含 2、3 和 5 的正整数。
//
//
//
// 示例 1：
//
//
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
//
//
//
//
// 提示：
//
//
// 1 <= n <= 1690
//
//
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 1131 👎 0

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

//Java：264. 丑数 II
public class P264UglyNumberIi {
    public static void main(String[] args) {
        Solution solution = new P264UglyNumberIi().new Solution();
        // TO TEST
        System.out.println(solution.nthUglyNumber(1407));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            int[] nums = new int[]{2, 3, 5};

            PriorityQueue<Long> pq = new PriorityQueue<>();
            Set<Long> set = new HashSet<>();

            pq.offer(1L);
            set.add(1L);

            for (int i = 1; i < n; i++) {
                Long min = pq.poll();

                for (int num : nums) {
                    long multi = min * num;
                    if (!set.contains(multi)) {
                        pq.offer(multi);
                        set.add(multi);
                    }
                }
            }

            return pq.poll().intValue();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
