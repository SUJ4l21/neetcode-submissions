class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(0,0,n,sb,res);
        return res;
    }
    private void backtrack(int i,int j ,int n,StringBuilder sb , List<String> res){
        if(i==j && i==n){
            res.add(sb.toString());
            return;
        }
        if(i<n){
            sb.append('(');
            backtrack(i+1,j,n,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }
        if(i>j){
            sb.append(')');
            backtrack(i,j+1,n,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
