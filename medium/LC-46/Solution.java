class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> vis = new HashSet<>();
        backtracking(ans, vis, nums, 0, new ArrayList<>());
        return ans;
    }

    public void backtracking(List<List<Integer>> ans, Set<Integer> vis, int[] nums, int index, List<Integer> temp) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!vis.contains(nums[i])) {
                    temp.add(nums[i]);
                    vis.add(nums[i]);
                    backtracking(ans, vis, nums, index + 1, temp);
                    temp.remove(index);
                    vis.remove(nums[i]);
                }
            }
        }
    }
}