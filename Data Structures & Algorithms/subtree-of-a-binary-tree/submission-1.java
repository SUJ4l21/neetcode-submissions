class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // If the main tree is empty, it can't contain a subtree
        if (root == null) return false;
        
        // If we found a matching structure right here, return true
        if (isSameTree(root, subRoot)) return true;
        
        // Otherwise, keep searching down both the left and right branches
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    // Helper function that strictly checks if two trees are exactly identical
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        
        // Both left and right MUST perfectly match
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}