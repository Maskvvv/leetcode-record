package leetcode.editor.cn;
//给定一个包含红色、白色和蓝色、共 n 个元素的数组
// nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//
//
//
//
// 必须在不使用库内置的 sort 函数的情况下解决这个问题。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
//
//
// 示例 2：
//
//
//输入：nums = [2,0,1]
//输出：[0,1,2]
//
//
//
//
// 提示：
//
//
// n == nums.length
// 1 <= n <= 300
// nums[i] 为 0、1 或 2
//
//
//
//
// 进阶：
//
//
// 你能想出一个仅使用常数空间的一趟扫描算法吗？
//
//
// Related Topics 数组 双指针 排序 👍 1633 👎 0


//Java：颜色分类
public class P75SortColors {
    public static void main(String[] args) {
        Solution solution = new P75SortColors().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            int length = nums.length;

            int p0 = 0;
            int p1 = 0;

            for (int i = 0; i < length; i++) {
                int num = nums[i];

                if (num == 1) {
                    swap(p1, i, nums);
                    p1++;
                } else if (num == 0) {
                    swap(p0, i, nums);
                    if (p0 < p1) {
                        swap(p1, i, nums);
                    }
                    p0++;
                    p1++;
                }
            }



        }


        public void swap(int p1, int p2, int[] nums) {
            int temp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
