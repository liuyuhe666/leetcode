# 螺旋矩阵 II

解题思路：模拟

按照如下的顺序对数组进行遍历赋值即可，注意处理好边界情况

-   从左到右，循环完成后，更新上边界
-   从上到下，循环完成后，更新右边界
-   从右到左，循环完成后，更新下边界
-   从下到上，循环完成后，更新左边界

具体代码如下：

```java
class Solution {
    public int[][] generateMatrix(int n) {
        // 边界
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] ans = new int[n][n];
        int num = 1, target = n * n;
        while (num <= target) {
            // 从左到右
            for (int i = l; i <= r; i++) ans[t][i] = num++;
            // 更新上边界
            t++;
            // 从上到下
            for (int i = t; i <= b; i++) ans[i][r] = num++;
            // 更新右边界
            r--;
            // 从右到左
            for (int i = r; i >= l; i--) ans[b][i] = num++;
            // 更新下边界
            b--;
            // 从下到上
            for (int i = b; i >= t; i--) ans[i][l] = num++;
            // 更新左边界
            l++;
        }
        return ans;
    }
}
```
