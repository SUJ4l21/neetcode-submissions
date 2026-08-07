class Solution {
    public boolean isMatch(String s, String p) {
        
        char [] c1 = s.toCharArray();
        char [] c2 = p.toCharArray(); 
        //return helper(0,0,c1,c2);
        int n = c1.length;
        int m = c2.length;
        boolean dp[][] = new boolean [n+1][m+2];
        dp[n][m] = true;
        for (int j = m - 2; j >= 0; j--) {
            if (c2[j + 1] == '*') {
                dp[n][j] = dp[n][j + 2];
            }
        }
        
        for(int i = n-1;i>=0;i--){
            for(int j = m-1; j >=0;j--){
                boolean start = (i<c1.length) && ((c1[i]==c2[j]) || c2[j]=='.');
                
                if(j+1<c2.length && c2[j+1]=='*'){
                    dp[i][j] = dp[i][j+2] || (start && dp[i+1][j]);
                }
                else if(start)dp[i][j]= dp[i+1][j+1];

                else dp[i][j] = false;
                
            }
        }
        return dp[0][0];
    }
    private boolean helper(int i,int j,char[]c1,char []c2){
        if(j>=c2.length){
            return i == c1.length;
        }

        boolean start = (i<c1.length) && ((c1[i]==c2[j]) || c2[j]=='.');
        if(j<c2.length-1 &&  c2[j+1]=='*'){
            return helper(i,j+2,c1,c2) || (start && helper(i+1,j,c1,c2));
        }
        if(start)return helper(i+1,j+1,c1,c2);
        return false;
        
    }
}
