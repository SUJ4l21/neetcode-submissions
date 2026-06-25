class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int []> q = new LinkedList<>();
        int r = grid.length;
        int c = grid[0].length;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==2)q.add(new int[] {i,j});
            }
        }
        int max = 0;
        while(!q.isEmpty()){
            int []node = q.poll();
            int row = node[0];
            int col = node[1];

            int[] drow = {1,0,-1,0};
            int[] dcol = {0,-1,0,1};
            for(int i=0;i<4;i++){
                int nrow = row +drow[i];
                int ncol = col +dcol[i];

                if(nrow >=r || ncol >=c || nrow<0 || ncol<0 || grid[nrow][ncol]!=1)continue;

                q.add(new int[]{nrow,ncol});
                grid[nrow][ncol] = grid[row][col]+1;
            }
            
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1)return -1;
                max = Math.max(max,grid[i][j]);
            }
        }
        return max>=2?max-2:max;
    }
}
