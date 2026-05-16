class MinStack {
    private Stack<Integer>s1 ;
    private Stack<Integer>s2 ;
    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int val) {
        s1.push(val);
        if(s2.isEmpty() || val <= s2.peek()){
            s2.push(val);
        }
    }
    
    public void pop() {
        if(s1.isEmpty())return;
        int top = s1.pop();
        if(top == s2.peek())s2.pop();
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return s2.peek();
    }
}
