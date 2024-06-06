class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 使用哈希表来判重
        Set<Character> vis = new HashSet<>();
        int n = s.length();
        int right = -1, ans = 0;
        for (int left = 0; left < n; left++) {
            // 左指针右移时，删除一个字符
            if (left != 0) {
                vis.remove(s.charAt(left - 1));
            }
            // 移动右指针
            while (right + 1 < n && !vis.contains(s.charAt(right + 1))) {
                vis.add(s.charAt(right + 1));
                ++right;
            }
            // 记录长度
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}