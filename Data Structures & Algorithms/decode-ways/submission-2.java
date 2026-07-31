class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(s,0,dp);
    }
    private int helper(String s , int i,int[]dp){
        if(i==s.length())return 1;

        if(s.charAt(i)=='0')return 0;
        if(dp[i]!=-1)return dp[i];
        int ways = helper(s,i+1,dp);

        if(i+1<s.length()){
            char cur = s.charAt(i);
            char next = s.charAt(i+1);

            if(cur == '1' || (cur=='2' && next <='6')){
                ways += helper(s,i+2,dp);
            }
        }
        dp[i]=ways;
        return ways;
    }
}
