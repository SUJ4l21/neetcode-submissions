class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][]dp = new int[n+1][m+1];
        if(grid[n-1][m-1]==1)return 0;

        dp[n-1][m-1] = 1;

        for(int i = n-1;i>=0;i--){
            for(int j = m-1;j>=0;j--){

                 if (i == n - 1 && j == m - 1) {
                    continue;
                }

               
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                int down=0,right=0;
                if(j+1<grid[0].length){
                    right = dp[i][j+1];
                }
                if(i+1<grid.length){
                    down = dp[i+1][j];
                }
                dp[i][j] = down + right ;
            }
        }
        return dp[0][0];
    }
    private int helper(int i,int j,int[][]grid){
        if(i==grid.length-1 && j== grid[0].length-1)return 1;
        if(grid[i][j]==1)return 0;
        int down=0,right=0;
        if(j+1<grid[0].length){
            right = helper(i,j+1,grid);
        }
        if(i+1<grid.length){
            down = helper(i+1,j,grid);
        }
        return down + right ; 
    }
}