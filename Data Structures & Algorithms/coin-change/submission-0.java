class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n+1][amount+1];
        
        for(int i=1;i<=amount;i++){
            dp[0][i]=Integer.MAX_VALUE-1;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                if(coins[i-1]<=j)dp[i][j]=Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][amount]==Integer.MAX_VALUE-1? -1 : dp[n][amount];
    }
    private int helper(int n,int[]coins,int amount){
        if(amount==0)return 0;
        if(n<0)return Integer.MAX_VALUE-1;

        if(coins[n]<=amount){
            return Math.min(1+helper(n,coins,amount-coins[n]),helper(n-1,coins,amount));
        }
        else return helper(n-1,coins,amount);
    }
}
