class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] dp = new int [n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = Integer.MAX_VALUE/2;
        }
        for(int i=0;i<=m;i++){
            dp[0][i] = Integer.MAX_VALUE/2;
        }
        dp[1][1] = grid[0][0];
        for(int i =1;i<=n;i++){
            for(int j =1;j<=m;j++){
                if(i==1 && j==1)continue;
                int up = grid[i-1][j-1] + dp[i-1][j];
                int left = grid[i-1][j-1] + dp[i][j-1];

                dp[i][j] =  Math.min(up, left);
            }
        }

        return dp[n][m];
    }
    private int helper(int i, int j, int[][] grid) {

        if (i == 1 && j == 1) {
            return grid[0][0];
        }

        if (i <= 0 || j <= 0) {
            return Integer.MAX_VALUE/2;
        }

        int up = grid[i-1][j-1] + helper(i - 1, j, grid);
        int left = grid[i-1][j-1] + helper(i, j - 1, grid);

        return Math.min(up, left);
    }
}