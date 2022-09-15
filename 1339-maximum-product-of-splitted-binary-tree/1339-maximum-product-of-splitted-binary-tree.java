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
    public int maxProduct(TreeNode root) {
        long total = sum(root);
        long[] res = new long[1];
        maxProduct(root, total, res);
        return (int) (res[0] % (1e9 + 7));
    }
    private long sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sum(root.left) + sum(root.right) + root.val;
    }
    private long maxProduct(TreeNode root, long total, long[] res) {
        if (root == null) {
            return 0;
        }
        long left = maxProduct(root.left, total, res);
        long right = maxProduct(root.right, total, res);
        long cur = left + right + root.val;
        res[0] = Math.max(res[0], cur * (total - cur));
        return cur;
    }
}