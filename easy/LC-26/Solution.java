class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int p = 1, q = 1;
        while (q < n) {
            if (nums[q] != nums[q - 1]) {
                nums[p] = nums[q];
                ++p;
            }
            ++q;
        }
        return p;
    }
}