class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int a : stones){
            pq.add(a);
        }
        
        while(pq.size()!=1){
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a-b);
        }
        return pq.poll();
    }
}
