class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 2];
        dp[n] = 1;
        for (int t = n - 1; t >= 0; t--) {
            dp[t] = dp[t + 1] + dp[t + 2];
        }
        return dp[0];
    }
}
