class Solution {
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int [][] dp = new int[m+1][n+1];

        for(int j =0;j<=n;j++){
            dp[m][j] = n - j;
        }
        for(int i =0;i<=m;i++){
            dp[i][n] = m - i;
        }

        for(int i = m-1;i>=0;i--){
            for(int j =n-1;j>=0;j--){
                if(s1.charAt(i)==s2.charAt(j))dp[i][j] = dp[i+1][j+1];
                else{
                    int insert = 1 + dp[i][j+1];
                    int delete = 1 + dp[i+1][j];
                    int replace = 1 + dp[i+1][j+1];
                    dp[i][j]= Math.min(Math.min(insert,delete),replace);
                }
            }
        }
        return dp[0][0];
    }
    private int helper(int i,int j,String s1,String s2){
        if (i == s1.length())
        return s2.length() - j;

        if (j == s2.length())
        return s1.length() - i;

        if(s1.charAt(i)==s2.charAt(j))return helper(i+1,j+1,s1,s2);
        else{
            int insert = 1 + helper(i,j+1,s1,s2);
            int delete = 1 + helper(i+1,j,s1,s2);
            int replace = 1 + helper(i+1,j+1,s1,s2);
            return Math.min(Math.min(insert,delete),replace);
        }

    }
}
