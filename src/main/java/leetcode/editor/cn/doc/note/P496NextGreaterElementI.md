**方法：单调栈**
**思路：**
我们可以忽略数组 nums1，先对将 nums2 中的每一个元素，求出其下一个更大的元素。随后对于将这些答案放入哈希映射（HashMap）中，再遍历数组 nums1，并直接找出答案。对于 nums2，我们可以使用单调栈来解决这个问题。

```
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] finList = new int[nums1.length];
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> hasMap = new HashMap<>();//存放 nums 数组中每项所对应的一边第一个最大的值

        //遍历整个 nums2 数组，将数组中的每个元素和栈顶的元素进行比较，
        // 1.如果该数大于栈顶元素则将栈顶元素出栈，并将此栈顶元素的右边第一个最大值设置为该数，接着在遍历栈中的下一个元素，直到栈为空
        // 2.如果该数小于栈顶元素则将其入栈
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]){
                hasMap.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);

        }
        //最后栈中可能会有一些数没有右边第一个最大的数，则一次将其出栈并将其value设置为-1
        while (!stack.isEmpty()){
            hasMap.put(stack.pop(),-1);
        }

        //遍历 nums1 数组，在 map 中查找其对应的右边第一个最大值，并将该值存入数组中返回
        for (int i = 0; i < finList.length; i++) {
            finList[i] = hasMap.get(nums1[i]);
        }

        return finList;

    }
}
```