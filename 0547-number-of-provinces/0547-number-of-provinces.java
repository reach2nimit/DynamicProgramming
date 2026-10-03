class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                dfs(visited, i, isConnected);
                count++;
            }
        }
        return count;
    }

    public void dfs(boolean[] visited,int node, int[][] isConnected){

        visited[node] = true;
        for(int i = 0; i<isConnected.length;i++){
            if(!visited[i] && isConnected[node][i] == 1)
                dfs(visited, i, isConnected);
        }
    }
}