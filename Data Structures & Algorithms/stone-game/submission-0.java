class Solution {
    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length+1][piles.length+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(0,piles.length-1,piles,dp)>0;
    }
    private int helper(int l,int r,int[]piles,int[][]dp){
        if(l==r)return piles[l];
        if(dp[l][r]!=-1)return dp[l][r];
        int left = piles[l] - helper(l+1,r,piles,dp);
        int right = piles[r] - helper(l,r-1,piles,dp);
        return dp[l][r]=Math.max(left,right);
    }
}