# 斐波那契数

解题思路：动态规划

状态转移方程：

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), n > 1

具体代码如下：

```java
class Solution {
    public int fib(int n) {
        if (n < 2) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
```

优化：分析代码，我们可以发现，状态 `i` 只与状态 `i - 1` 和 `i - 2` 有关，因此，我们可以用两个变量来保存前两个状态，而不必使用数组。

```java
class Solution {
    public int fib(int n) {
        if (n < 2) return n;
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
```
