class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int []indegree = new int[n];
        Arrays.fill(indegree,Integer.MAX_VALUE);
        for(int[] x : flights){
            adj.get(x[0]).add(new int[]{x[1],x[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,src,0});

        while(!pq.isEmpty()){
            int node[] = pq.poll();
            int cost = node[0];
            int x = node[1];
            int time = node[2];
            if(time<=k+1 && x == dst)return cost;
            for(int []arr : adj.get(x)){
                int a = arr[0];
                int w = arr[1];
                pq.add(new int[]{cost+w,a,time+1});
            }
        }
        return -1;
    }
}
