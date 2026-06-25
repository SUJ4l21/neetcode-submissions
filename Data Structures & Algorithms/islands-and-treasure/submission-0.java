class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int a = grid.length;
        int b = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    q.add(new int[]{i,j});  
                }
            }
        }
        if(q.isEmpty())return;

        while(!q.isEmpty()){
            int [] node = q.poll();
            int row = node[0];
            int col = node[1];

            int[] drow = {1,0,-1,0};
            int[] dcol = {0,-1,0,1};
            for(int i=0;i<4;i++){
                int r = row + drow[i];
                int c = col + dcol[i];
                if(r>=a || c >=b || r<0 || c<0 || grid[r][c]!=Integer.MAX_VALUE)continue;
                q.add(new int[]{r,c});
                grid[r][c]= grid[row][col]+1;
            }
        }
    }
    
}
