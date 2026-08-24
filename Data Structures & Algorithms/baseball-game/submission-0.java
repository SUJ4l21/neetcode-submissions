class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s = new Stack<>();
        for(String st : operations){
            if(!st.equals("C") &&  !st.equals("D") && !st.equals("+")){
                s.push(Integer.parseInt(st));
            }
            else if(st.equals("+")){
                int a = s.pop();
                int b = s.pop();
                int c = a+b;
                s.push(b);s.push(a);s.push(c);
            }
            else if(st.equals("C")){
                s.pop();
            }
            else if(st.equals("D")){
                s.push(2*s.peek());
            }
        }
        int sum=0;
        while(!s.isEmpty()){
            int a = s.pop();
            sum+=a;
        }   
        return sum;
    }
}