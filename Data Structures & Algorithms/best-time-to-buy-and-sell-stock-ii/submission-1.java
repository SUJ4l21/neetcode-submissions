class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+1][2];
        for(int[]arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(0,1,prices,dp);
    }
    private int helper(int i, int canbuy,int[]prices,int[][]dp){
        if(i==prices.length)return 0;
        if(dp[i][canbuy]!=-1)return dp[i][canbuy];
        if(canbuy==1){
            return dp[i][canbuy]= Math.max(-prices[i] + helper(i+1,0,prices,dp),helper(i+1,1,prices,dp));
        }else{
            return dp[i][canbuy]= Math.max(prices[i]+ helper(i+1,1,prices,dp),helper(i+1,0,prices,dp));
        }
    }
}