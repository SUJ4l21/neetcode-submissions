class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int i:nums){
            total+=i;
        }
        if(total%2!=0)return false;
        total/=2;
        int n = nums.length;
        boolean[][]dp = new boolean[n+1][total+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<total+1;i++){
            dp[0][i]=false;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<total+1;j++){
                if(nums[i-1]<=j){
                    dp[i][j]=dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][total];
    }
}
