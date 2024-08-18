# 移除元素

解题思路：双指针

快指针`fast`: 遍历原数组，寻找要删除的元素

慢指针`slow`: 指向新数组的末尾

代码如下：

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        for (fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
```

时间复杂度：`O(N)`

空间复杂度：`O(1)`
