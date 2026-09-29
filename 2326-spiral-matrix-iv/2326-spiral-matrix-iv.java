/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        
        int[][] matrix = new int[m][n];
        ListNode curr = head;
        int val = curr.val;

        int top = 0, bottom = m-1;
        int left = 0, right = n - 1;

        while(top <= bottom && left <= right){

                for(int i = left; i <= right; i++){
                    if(curr != null){
                        matrix[top][i] = curr.val;
                        curr = curr.next;
                    }
                    else
                        matrix[top][i] = -1;
                }
                
                top++;

                for(int i = top; i<=bottom; i++){
                    if(curr != null){
                        matrix[i][right] = curr.val;
                        curr = curr.next;
                    }
                    else
                        matrix[i][right] = -1;
                }

                right--;

                if(top<=bottom){
                    for(int i = right; i>=left; i--){
                        if(curr != null){
                            matrix[bottom][i] = curr.val;
                            curr = curr.next;
                        }
                        else
                            matrix[bottom][i] = -1;
                    }
                    bottom--;
                }

                if(left <= right){
                    for(int i = bottom; i>=top; i--){
                        if(curr != null){
                            matrix[i][left] = curr.val;
                            curr = curr.next;
                        }
                        else
                             matrix[i][left] = -1;
                    }
                    left++;
                }  
        }

        return matrix;

    }
}