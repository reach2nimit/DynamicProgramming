class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(0, visited, rooms);

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                return false;
            }
        }

        return true;
    }

    public void dfs(int room, boolean[] visited, List<List<Integer>> rooms){
        visited[room] = true;
        List<Integer> keys = rooms.get(room);
        
        for(int key : keys){
            if(!visited[key]) 
                dfs(key, visited, rooms);
        }
    }
}