package leetcode.editor.cn;
//基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
//
// 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
//
//
// 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
//
//
// 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 bank 中）
//
// 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成
//此基因变化，返回 -1 。
//
// 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
//
//
//
// 示例 1：
//
//
//输入：start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
//输出：1
//
//
// 示例 2：
//
//
//输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA",
//"AAACGGTA"]
//输出：2
//
//
// 示例 3：
//
//
//输入：start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC",
//"AACCCCCC"]
//输出：3
//
//
//
//
// 提示：
//
//
// start.length == 8
// end.length == 8
// 0 <= bank.length <= 10
// bank[i].length == 8
// start、end 和 bank[i] 仅由字符 ['A', 'C', 'G', 'T'] 组成
//
//
// Related Topics 广度优先搜索 哈希表 字符串 👍 272 👎 0

import leetcode.editor.cn.utils.ArrayUtils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

//Java：433. 最小基因变化
public class P433MinimumGeneticMutation {
    public static void main(String[] args) {
        Solution solution = new P433MinimumGeneticMutation().new Solution();
        // TO TEST
        System.out.println(solution.minMutation(
                "AACCTTGG",
                "AATTCCGG",
                ArrayUtils.generateStringArray("[\"AATTCCGG\",\"AACCTGGG\",\"AACCCCGG\",\"AACCTACC\"]")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[] word = new char[]{'A', 'C', 'G', 'T'};

        public int minMutation(String startGene, String endGene, String[] bank) {
            Set<String> bankSet = new HashSet<>();

            for (String s : bank) {
                bankSet.add(s);
            }

            Set<String> visited = new HashSet<>();
            visited.add(startGene);

            Deque<Object[]> queue = new ArrayDeque<>();
            queue.addLast(new Object[]{startGene, 0});

            while (!queue.isEmpty()) {
                Object[] p = queue.removeFirst();
                String curGene = (String) p[0];
                int curStep = (int) p[1];

                if (curGene.equals(endGene)) return curStep;


                for (int i = 0; i < curGene.length(); i++) {
                    for (char w : word) {
                        char[] chars = curGene.toCharArray();
                        chars[i] = w;
                        String nextGene = new String(chars);
                        if (bankSet.contains(nextGene) && !visited.contains(nextGene)) {
                            visited.add(nextGene);
                            queue.addLast(new Object[]{nextGene, curStep + 1});
                        }
                    }
                }
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
