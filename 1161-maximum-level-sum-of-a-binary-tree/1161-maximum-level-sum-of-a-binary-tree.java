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
    public int maxLevelSum(TreeNode root) {
        
        if(root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        int level = 1;
        int maxLevel = 1;
        int maxSum = Integer.MIN_VALUE;

        while(!queue.isEmpty()){

            int qSize = queue.size();
            int sum = 0;

            while(qSize > 0){

                TreeNode curr = queue.poll();

                if(curr != null){
                    sum += curr.val;

                    if(curr.left != null)
                        queue.offer(curr.left);
                    
                    if(curr.right != null)
                        queue.offer(curr.right);
                }

                qSize--;
            }

            if(sum > maxSum){
                maxSum = sum;
                maxLevel = level;
            }
                
            level++;
        }

        return maxLevel;
    }
}