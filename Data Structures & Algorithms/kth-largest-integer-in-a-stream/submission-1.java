class KthLargest {
    private PriorityQueue<Integer> pq ;
    private int k ;

    public KthLargest(int k, int[] nums) {
    pq = new PriorityQueue<>((a,b) -> Integer.compare(b , a));
    this.k = k;
        for(int a : nums){
            pq.add(a);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        Stack<Integer> s = new Stack();
        for(int i =1;i<k;i++ ){
            s.push(pq.poll());
        }
        int res = pq.poll();
        pq.add(res);
        while(!s.isEmpty()){
            pq.add(s.pop());
        }
        return res;
    }
}
