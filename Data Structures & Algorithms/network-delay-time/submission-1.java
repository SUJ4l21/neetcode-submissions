class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int []>> adj= new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new int[]{times[i][1],times[i][2]});
        }
        int[]dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        dist[k]=0;
        pq.add(new int[]{0,k});

        while(!pq.isEmpty()){
            int []node = pq.poll();
            int v = node[1];
            int d = node[0];
            
            for(int i=0;i<adj.get(v).size();i++){
                int nv = adj.get(v).get(i)[0];
                int nd = adj.get(v).get(i)[1];

                if(dist[nv]>d+nd){
                    dist[nv] = d+nd;
                    pq.add(new int[]{dist[nv],nv});
                }
            }
        }
        int max = 0; 
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}
