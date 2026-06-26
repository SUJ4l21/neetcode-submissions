class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int n = heights.length;
        int m = heights[0].length;
        int [][] pacific = new int[n][m];
        int [][] atlantic = new int[n][m];
        Queue<int[]> pacq = new LinkedList<>();
        Queue<int[]> atlq = new LinkedList<>();
        for(int i=0;i<m;i++){
            pacq.add(new int[]{0,i});
            atlq.add(new int[]{n-1,i});
        }
        for(int i=0;i<n;i++){
            pacq.add(new int[]{i,0});
            atlq.add(new int[]{i,m-1});
        }
        bfs(pacq,pacific,heights);
        bfs(atlq,atlantic,heights);

        for(int i=0;i<n;i++){
            for( int j=0;j<m;j++){
                if(pacific[i][j]==1 && atlantic[i][j]==1){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    private void bfs(Queue<int[]>q,int[][]ocean,int [][]heights){
        while(!q.isEmpty()){
            int []node = q.poll();
            int r = node[0];
            int c = node[1];
            ocean[r][c]=1;
            int drow[]={1,0,-1,0};
            int dcol[]={0,-1,0,1};

            for(int i=0;i<4;i++){
                int nr = r+drow[i];
                int nc = c+dcol[i];

                if( nr>=0 && nr < heights.length && nc >=0 && nc <heights[0].length && ocean[nr][nc]!=1 && heights[nr][nc]>=heights[r][c]){
                    q.add(new int[]{nr,nc});
                }
            }
        }
        
    }
}
