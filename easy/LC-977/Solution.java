class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1, k = n - 1;
        int[] ans = new int[n];
        while (left <= right) {
            if (nums[left] * nums[left] < nums[right] * nums[right]) {
                ans[k--] = nums[right] * nums[right];
                right--;
            } else {
                ans[k--] = nums[left] * nums[left];
                left++;
            }
        }
        return ans;
    }
}
