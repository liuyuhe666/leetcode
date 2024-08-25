# 两个数组的交集

解题思路：哈希表

将`数组1`中的元素加入哈希表，然后遍历`数组2`中的元素，如果该元素出现在哈希表中，则将该元素加入到结果集中。

具体代码如下：

```java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> ans = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                ans.add(i);
            }
        }
        return ans.stream().mapToInt(x -> x).toArray();
    }
}
```
