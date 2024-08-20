# 长度最小的子数组

解题思路：滑动窗口

`i`: 代表滑动窗口的左边界

`j`: 代表滑动窗口的右边界

`sum`: 代表窗口中所有元素的和

遍历数组，枚举窗口的结束位置 `j`，当窗口中的元素和，大于等于目标值时，再移动窗口的起始位置（缩小窗口），每当 `sum`（窗口中所有元素的和） 大于等于目标值时，记录下此时窗口的长度，取长度的最小值即可。

具体代码如下：

```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, sum = 0, ans = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) {
                ans = Math.min(ans, j - i + 1);
                sum -= nums[i++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

```
