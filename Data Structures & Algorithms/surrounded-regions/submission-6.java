class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        Queue<int []> q = new LinkedList<>();
        int [][] vis = new int [n][m];
        for(int i=0;i<m;i++){
            if(board[0][i]=='O')q.add(new int[]{0,i});
            if(board[n-1][i]=='O')q.add(new int[]{n-1,i});
        }
        for(int i=0;i<n;i++){
            if(board[i][0]=='O')q.add(new int[]{i,0});
            if(board[i][m-1]=='O')q.add(new int[]{i,m-1});
        }
        bfs(q,vis,board);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && vis[i][j]==0){
                    board[i][j]='X';
                }
            }
        }
    }
    private void bfs(Queue<int[]>q ,int[][]vis,char[][]board){
        while(!q.isEmpty()){
            int[]node = q.poll();
            int r = node[0];
            int c = node[1];
            vis[r][c]=1;

            int drow[] = {1,0,-1,0};
            int dcol[] = {0,1,0,-1};
            for(int i = 0;i<4;i++){
                int nr = r+drow[i];
                int nc = c+dcol[i];

                if(nr>=0 && nr<board.length && nc>=0 && nc<board[0].length && vis[nr][nc]==0 && board[nr][nc]=='O'){
                    q.add(new int[]{nr,nc});
                }
            }
        }
    }
}
