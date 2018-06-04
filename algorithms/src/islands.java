public class islands {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]=='1') {
                    dfs(i,j,grid.length-1, grid[0].length-1, grid);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int i, int j, int row, int col, char[][]grid) {
        if(i<0 || j<0 || i>row || j> col || grid[i][j] == '0'){
            return ;
        }

        grid[i][j] = '0';

        dfs(i-1,j,row, col, grid);
        dfs(i+1,j,row, col, grid);
        dfs(i,j-1,row, col, grid);
        dfs(i,j+1,row, col, grid);

    }

    private void bfs(int i, int j, int row, int col, char[][] grid) {

    }
}