package leetcode.editor.cn;
//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
//
//
//
// 示例 1:
//
//
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
//
//
// 示例 2:
//
//
//输入: nums = [1], k = 1
//输出: [1]
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// k 的取值范围是 [1, 数组中不相同的元素的个数]
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
//
//
//
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
//
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 1709 👎 0

import leetcode.editor.cn.utils.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Java：347. 前 K 个高频元素
public class P347TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new P347TopKFrequentElements().new Solution();
        // TO TEST

        System.out.println(Arrays.toString(solution.topKFrequent(ArrayUtils.generateNumArray("[1,1,1,2,2,3]"), 2)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {

            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(i -> -i[1]));
            Map<Integer, Integer> map = new HashMap<>();

            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (priorityQueue.size() == k && priorityQueue.peek()[1] < entry.getValue()) {
                    priorityQueue.poll();
                }
                priorityQueue.offer(new int[]{entry.getKey(), entry.getValue()});
            }

            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = priorityQueue.poll()[0];
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
