class Solution {
    public int countBattleships(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        int shipCount = 0;
        //DFS
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 'X' && !visited[i][j]){
                    //Check neighbors
                    checkNeighbors(board, i, j, visited);
                    shipCount++;
                }
            }
        }
        return shipCount;
    }
    
    public void checkNeighbors(char[][] board, int i, int j, boolean[][] visited){
        visited[i][j] = true;
        if(j < board[i].length - 1 && board[i][j+1] == 'X' && !visited[i][j+1])
            checkNeighbors(board, i, j + 1, visited);
        if(i < board.length - 1 && board[i + 1][j] == 'X' && !visited[i+1][j])
            checkNeighbors(board, i + 1, j, visited);
    }
}