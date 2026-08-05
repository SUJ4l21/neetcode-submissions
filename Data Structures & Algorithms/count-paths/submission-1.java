class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp  = new int[m+1][n+1];
        dp[m-1][n-1] = 1;

        for(int i = m-1;i>=0;i--){
            for(int j = n-1;j>=0;j--){

                if (i == m - 1 && j == n - 1)
                    continue;
                int r =0,d=0;
                if(i+1<m)r = dp[i+1][j];
                if(j+1<n)d = dp[i][j+1];
                dp[i][j] = r+d;
            }
        }
        return dp[0][0];
    }
    private int solve(int i,int j,int m,int n,int[][]dp){
        if(i==m-1 && j==n-1)return 1;
        if(dp[i][j]!=-1)return dp[i][j];
        int right=0,down=0;
        if(i<m){
            right =  solve(i+1,j,m,n,dp);
        }
        if(j<n){
            down =  solve(i,j+1,m,n,dp);
        }
        return dp[i][j] =  right+down;
    }
}
