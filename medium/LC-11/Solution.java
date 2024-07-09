class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        while (left < right) {
            int s = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, s);
            // 每次移动数值最小的那个指针
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}