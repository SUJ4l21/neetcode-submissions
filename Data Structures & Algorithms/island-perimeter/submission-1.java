class Solution {
    public int islandPerimeter(int[][] grid) {
        int total = 0;
        int n = grid.length;
        int m = grid[0].length;

        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){

                if(grid[i][j]>=1){
                    int[] dr = {1,0,-1,0};
                    int[] dc = {0,1,0,-1};
                    for(int k =0;k<4;k++){
                        int r = i+dr[k];
                        int c = j+dc[k];
                        if(r>=0 && r<n && c>=0 && c<m && grid[r][c]>0){
                            grid[i][j]+=1;
                        }
                    }
                    total++;
                }

            }
        }

        total = total*4;

        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(grid[i][j]>0)total -= (grid[i][j] -1);

            }
        }
        return total;
    }
}