package com.leetcode;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (null == root) {
			return false;
		}
		if (root.left == null && root.right == null) {
            return root.val == sum;
        }
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		PathSum hasPathSum = new PathSum();
		System.out.println(hasPathSum.hasPathSum(root, 22));
	}
}
