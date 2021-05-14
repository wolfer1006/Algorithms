class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        Set<Integer> visited = new HashSet<Integer>();
        for(int i = 0; i < isConnected.length; i++){
            if(!visited.contains(i)){
                dfs(isConnected, i, visited);
                provinces++;
            }
        }
        
        return provinces;
    }
    
    public void dfs(int[][] isConnected, int i, Set<Integer> visited){
        for(int j = 0; j < isConnected[i].length; j++){
            if(isConnected[i][j] == 1 && !visited.contains(j)){
                visited.add(j);
                dfs(isConnected, j, visited);
            }
        }
    }
}