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
        List<String> result = new ArrayList();

        helperFunction(result, root, "");

        return result;
    }

    public void helperFunction(List<String> result, TreeNode root, String path){

        path = path + root.val;

        if(root.left == null && root.right == null)
            result.add(path);
        
        else{

            if(root.left != null)
                helperFunction(result, root.left, path + "->");

            if(root.right != null)
                helperFunction(result, root.right, path + "->");
        }
    }
}