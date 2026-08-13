class Solution {
    public int lastStoneWeightII(int[] stones) {
    int sum = 0;
        for(int i: stones){
            sum+=i;
        }
        int target = (int) Math.ceil(sum/2);
        int [][]dp = new int[stones.length +1][sum];
        for(int [] a : dp){
            Arrays.fill(a,-1);
        }
        return helper(0,0,stones,target,sum,dp);
    }
    private int helper(int i,int total,int[]stones,int target,int sum,int [][]dp){
        if(total>=target || i == stones.length)return Math.abs((total - (sum-total)));
        if(dp[i][total]!=-1)return dp[i][total];

        return dp[i][total] = Math.min(helper(i+1,total,stones,target,sum,dp),helper(i+1,total+stones[i],stones,target,sum,dp));
    }
}