class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] dp = new int[m+1][n+1];
        for(int[]arr : dp){
            Arrays.fill(arr,-1);
        }
        int ans = Integer.MIN_VALUE;
        for(int i = m-1;i>=0;i--){
            for(int j = n-1;j>=0;j--){
                ans = Math.max(ans,1+helper(i,j,matrix,dp));
            }
        }
        return ans;
    }
    private int helper(int i,int j,int [][]matrix,int[][]dp){
        if(i>=matrix.length || i<0 || j>=matrix[0].length || j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];

        int up=0,down=0,right=0,left=0;
        if(i>0 && matrix[i-1][j]>matrix[i][j]){
            up = 1 + helper(i-1,j,matrix,dp);
        }
        if(i<matrix.length-1 && matrix[i+1][j]>matrix[i][j]){
            down = 1 + helper(i+1,j,matrix,dp);
        }
        if(j>0 && matrix[i][j-1]>matrix[i][j]){
            left = 1 + helper(i,j-1,matrix,dp);
        }
        if(j<matrix[0].length-1 && matrix[i][j+1]>matrix[i][j]){
            right = 1 + helper(i,j+1,matrix,dp);
        }
        return dp[i][j] = Math.max(Math.max(up,down),Math.max(right,left));
    }
}
