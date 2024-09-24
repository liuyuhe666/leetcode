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