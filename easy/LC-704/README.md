# 二分查找

前提条件：

-   数组中的元素是有序的
-   数组中没有重复的元素，如果有重复的元素，那么查找到的下标就不唯一了

第一种写法，区间左右均闭合，`[left, right]`

```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 2);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
```

第二种写法，区间左闭右开，`[left, right)`

```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 2);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }
}

```

总结：二分查找属于比较基础的算法，应注意区间端点的处理。
