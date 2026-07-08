class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int [][]vis = new int[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{grid[0][0],0,0});
        vis[0][0]=1;

        while(!pq.isEmpty()){
            int []node = pq.poll();
            int t = node[0];
            int r = node[1];
            int c = node[2];
            if(r==n-1 && c==n-1)return t;
            int[] dr ={-1,0,1,0};
            int[] dc ={0,1,0,-1};
            for(int i=0;i<4;i++){
                int nr = r+dr[i];
                int nc = c+dc[i];

                if(nr>=0 && nc>=0 && nr<n && nc<n && vis[nr][nc]!=1){
                    vis[nr][nc]=1;
                    pq.add(new int[]{Math.max(t,grid[nr][nc]),nr,nc});
                }
            }
        }
        return n;
    }
}
