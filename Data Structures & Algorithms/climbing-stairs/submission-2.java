class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 2];
        dp[n] = 1;
        for (int t = n - 1; t >= 0; t--) {
            dp[t] = dp[t + 1] + dp[t + 2];
        }
        return dp[0];
    }
    public int helper(int t,int n,int dp[]){
        if(t==n)return 1;
        if(t>n)return 0;
        if(dp[t]!=-1)return dp[t];
        return dp[t] = helper(t+1,n,dp)+helper(t+2,n,dp);
    }
}
