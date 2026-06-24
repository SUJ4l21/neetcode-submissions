class Solution {
    int count =0;
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        for(int i= 0 ;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                    count++;
                    bfs(i,j,grid,vis);
                }
            }
        }
        return count;
    }
    private void bfs(int i,int j,char [][] grid,int [][]vis){
        vis[i][j]=1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        int r = grid.length;
        int c = grid[0].length;
        while(!q.isEmpty()){
            int row = q.peek().a;
            int col = q.peek().b;
            q.remove();
            int drow[] = {-1,0,1,0};
            int dcol[] = {0,-1,0,1};

            for(int k=0;k<4;k++){
                    int nrow = row +drow[k];
                    int ncol = col + dcol[k];
                    if(nrow>=0 && nrow<r && ncol >=0 && ncol<c && grid[nrow][ncol]=='1' && vis[nrow][ncol]==0){
                        vis[nrow][ncol]=1;
                        q.add(new Pair(nrow,ncol));
                    }
            }
        }
    }
}
class Pair{
    int a;
    int b;
    public Pair(int a,int b){
        this.a =a;
        this.b = b;
    }
}
