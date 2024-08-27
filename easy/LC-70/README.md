# 爬楼梯

状态转移方程如下：

i = 1 时，dp[i] = 1

i = 2 时，dp[i] = 2

i > 2 时，dp[i] = dp[i - 1] + dp[i - 2]

从方程中，我们可以看出，某次的状态只和前两次的状态有关

因此，我们可以使用两个变量来存储前两次的状态，从而降低算法的空间复杂度（滚动数组）

```java
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int p = 1, q = 2, ans = 0;
        for (int i = 3; i <= n; i++) {
            ans = p + q;
            p = q;
            q = ans;
        }
        return ans;
    }
}
```
