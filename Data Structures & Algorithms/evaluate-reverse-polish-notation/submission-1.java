class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> s = new Stack<>();
        for(int i =0;i<n;i++){
            if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/") ){
                int num = Integer.parseInt(tokens[i]);
                s.push(num);
            }else{

            int b = s.pop();
            int a = s.pop();
            s.push(find(a,b,tokens[i]));
            }
        }
        return s.pop();
    }
    public int find(int a ,int b ,String s){
        if(s.equals("+")){
            return a+b;
        }else if(s.equals("-")){
            return a-b;
        }else if(s.equals("*")){
            return a*b;
        }else{
            return a/b;
        }
    }
}
