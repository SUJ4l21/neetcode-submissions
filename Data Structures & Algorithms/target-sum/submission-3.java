class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int x : nums){
            sum += x;
        }
        if (Math.abs(target) > sum)
            return 0;
        int dp[][] = new int[n+1][2*sum+1];
        int offset = target;
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        // dp[0][0]=1;
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=target;j++){
        //         dp[i][j] = dp[i-1][target-nums[i-1]]+dp[i-1][target+nums[i-1]];
        //     }
        // }
        return helper(n,target,nums,dp,sum);
    }
    public int helper(int n,int target,int []nums,int[][]dp,int offset){
         if (Math.abs(target) > offset)
            return 0;
        if(n==0){
            if(target==0)return 1;
            return 0;
        }
        if(dp[n][target+offset]!=-1)return dp[n][target+offset];
        return dp[n][target+offset]= helper(n-1,target-nums[n-1],nums,dp,offset)+helper(n-1,target+nums[n-1],nums,dp,offset);

    }
}
