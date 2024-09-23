# 每日温度

解题思路：单调栈

一维数组中，要求找到任意一个元素的右边或左边第一个比自己大或者小的元素的位置时，我们可以使用单调栈来解决。

时间复杂度为 `O(N)`

本题的实质是，在一维数组中，找到一个元素右边第一个比自己大的元素的位置，因此可以使用单调栈来解决。

具体代码如下：

```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
```
