# 课程表

解题思路：拓扑排序

使用链式前向星的存图方式，如果课程 `a` 存在前置的课程 `b`，那我们就添加一条从 `b` 到 `a` 的边，并统计所有顶点的入度。

首先，将所有入度为 0 的顶点（没有前置条件的课程）加入到队列，然后从队头取出一个顶点，并将该顶点相连的顶点入度减一，如果此时某个顶点的入度为 0，则将其加入到队列中，重复上述过程，直到队列为空。

如果所有的课程都能顺利出队，则说明所有课程都能完成，此时返回 `true`，否则返回 `false`。

具体代码如下：

```java
class Solution {
    int N = 2010, M = 5010;
    int[] in = new int[N], he = new int[N], e = new int[M], ne = new int[M];
    int idx = 0;

    private void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx;
        in[b]++;
        idx++;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Arrays.fill(he, -1);
        for (int[] i : prerequisites) {
            add(i[1], i[0]);
        }
        int ans = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                q.addLast(i);
            }
        }
        while (!q.isEmpty()) {
            int x = q.pollFirst();
            ans++;
            for (int i = he[x]; i != -1; i = ne[i]) {
                int y = e[i];
                if (--in[y] == 0) {
                    q.addLast(y);
                }
            }
        }
        return ans == numCourses;
    }
}
```
