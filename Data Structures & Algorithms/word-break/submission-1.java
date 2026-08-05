class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String st : wordDict){
            set.add(st);
        }
        Boolean [] dp = new Boolean[s.length()+1];
        Arrays.fill(dp,null);
        return solve(0,s,set,dp);
    }
    private boolean solve(int i,String s,Set<String> set,Boolean []dp){
        if(i==s.length())return true;
        if(dp[i]!=null)return dp[i];
        boolean res = false;
        for(int k = i;k<s.length();k++){

            if( set.contains(s.substring(i,k+1))){
                if( solve(k+1,s,set,dp)){
                    return dp[i]=true;
                }
            }
        }
        return dp[i] = res;
    }
}
