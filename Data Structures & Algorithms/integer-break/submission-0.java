class Solution {
    public int integerBreak(int n) {
        int[][] dp = new int[n+1][n+1];
        for(int[]arr : dp){
            Arrays.fill(arr,-1);
        }
        return helper(1, n, n - 1,dp);
    }
    
    private int helper(int i, int remain, int limit,int[][]dp) {
        if (remain == 0) return 1;
        if (i > limit || i > remain) return 0; 
        if(dp[i][remain]!=-1)return dp[i][remain];
        int nopick = helper(i + 1, remain, limit,dp);
        int pick = i * helper(i, remain - i, limit,dp);
        
        return dp[i][remain]= Math.max(pick, nopick);
    }
}