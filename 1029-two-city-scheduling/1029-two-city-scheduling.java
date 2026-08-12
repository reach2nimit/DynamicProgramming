class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int totalCost = 0;
        int n = costs.length/2;
        Arrays.sort(costs, (a,b) ->{
            return (a[0] - a[1]) - (b[0] - b[1]);
        });

        for(int i = 0; i < n; i++){
            totalCost += costs[i][0];
            totalCost += costs[n+i][1];
        }
        return totalCost;
    }
    //try to understand the sorting part logic
}