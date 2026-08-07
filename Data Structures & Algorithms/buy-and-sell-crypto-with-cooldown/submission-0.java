class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][]dp = new int[n+2][2];

        for(int i = n-1;i>=0;i--){
            for(int j = 0;j<2;j++){
                if(j==1){
                    dp[i][j] = Math.max(-prices[i]+dp[i+1][0],dp[i+1][j]);
                }else{
                    dp[i][j] = Math.max(prices[i]+dp[i+2][1],dp[i+1][j]);
                }
            }
        }

        return dp[0][1];
    }
    private int helper(int i,int buy, int[]prices){
        if(i>=prices.length)return 0;

        if(buy==1){
            return Math.max(-prices[i]+helper(i+1,0,prices),helper(i+1,1,prices));
        }else{
            return Math.max(prices[i]+helper(i+2,1,prices),helper(i+1,0,prices));
        }
    }
}
