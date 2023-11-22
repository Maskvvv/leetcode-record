package leetcode.editor.cn;
//给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
//
// 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,2,3,2]
//输出：3
//
//
// 示例 2：
//
//
//输入：nums = [0,1,0,1,0,1,99]
//输出：99
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 10⁴
// -2³¹ <= nums[i] <= 2³¹ - 1
// nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
//
//
// Related Topics 位运算 数组 👍 1165 👎 0

import leetcode.editor.cn.utils.ArrayUtils;

//Java：137. 只出现一次的数字 II
public class P137SingleNumberIi {
    public static void main(String[] args) {
        Solution solution = new P137SingleNumberIi().new Solution();
        // TO TEST
        System.out.println(solution.singleNumber(ArrayUtils.generateNumArray("[-2,-2,1,1,4,1,4,4,-4,-2]")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int res = 0;

            for (int i = 0; i < 32; i++) {
                int count = 0;
                for (int num : nums) {
                    count += (num >>> i) & 1;
                }

                res |= (count % 3) << i;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
