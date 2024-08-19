# 有序数组的平方

解题思路：双指针

由于原数组为有序数组，那么将数组中的元素都平方后，最大值一定出现在数组的两端。

利用这一特性，我们可以用双指针来解决这道题目。

指针 `left`: 指向原数组的起始位置，不断右移

指针 `right`: 指向原数组的末尾，不断左移

将两个指针所指位置处的元素进行平方，比较大小，将大的放到新数组的末尾，直到两个指针相遇为止。

具体代码如下：

```java
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1, k = n - 1;
        int[] ans = new int[n];
        while (left <= right) {
            if (nums[left] * nums[left] < nums[right] * nums[right]) {
                ans[k--] = nums[right] * nums[right];
                right--;
            } else {
                ans[k--] = nums[left] * nums[left];
                left++;
            }
        }
        return ans;
    }
}

```
