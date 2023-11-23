package leetcode.editor.cn;
//给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
//
// 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
//
// 请找到和最小的 k 个数对 (u1,v1), (u2,v2) ... (uk,vk) 。
//
//
//
// 示例 1:
//
//
//输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//输出: [1,2],[1,4],[1,6]
//解释: 返回序列中的前 3 对数：
//     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
//
//
// 示例 2:
//
//
//输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//输出: [1,1],[1,1]
//解释: 返回序列中的前 2 对数：
//     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
//
//
// 示例 3:
//
//
//输入: nums1 = [1,2], nums2 = [3], k = 3
//输出: [1,3],[2,3]
//解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
//
//
//
//
// 提示:
//
//
// 1 <= nums1.length, nums2.length <= 10⁵
// -10⁹ <= nums1[i], nums2[i] <= 10⁹
// nums1 和 nums2 均为升序排列
// 1 <= k <= 10⁴
//
//
// Related Topics 数组 堆（优先队列） 👍 539 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//Java：373. 查找和最小的 K 对数字
public class P373FindKPairsWithSmallestSums {
    public static void main(String[] args) {
        Solution solution = new P373FindKPairsWithSmallestSums().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            int m = nums1.length, n = nums2.length;

            List<List<Integer>> res = new ArrayList<>(k);
            PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> (i1[0] - i2[0]));

            for (int i = 0; i < Math.min(m, k); i++) {
                pq.add(new int[]{nums1[i] + nums2[0], i, 0});
            }

            while (!pq.isEmpty() && res.size() < k) {
                int[] indexArray = pq.poll();

                int x = indexArray[1], y = indexArray[2];
                res.add(Arrays.asList(nums1[x], nums2[y]));
                if (y + 1 < n) {
                    pq.add(new int[]{nums1[x] + nums2[y + 1], x, y + 1});
                }
            }

            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
