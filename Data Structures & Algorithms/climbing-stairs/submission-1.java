class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(0,n,dp);
    }
    public int helper(int t,int n,int dp[]){
        if(t==n)return 1;
        if(t>n)return 0;
        if(dp[t]!=-1)return dp[t];
        return dp[t] = helper(t+1,n,dp)+helper(t+2,n,dp);
    }
}
