/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        backtracking(root, new StringBuilder(), ans);
        return ans;
    }

    void backtracking(TreeNode root, StringBuilder path, List<String> ans) {
        if (root == null) return;

        // 记录此时的长度
        int len = path.length();
        path.append(root.val);

        if (root.left == null && root.right == null) {
            // 叶子
            ans.add(path.toString());
        } else {
            // 非叶子
            path.append("->");
            backtracking(root.left, path, ans);
            backtracking(root.right, path, ans);
        }
        // 回溯
        path.setLength(len);
    }
}