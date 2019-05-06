import java.util.LinkedList;

class Solution64 {
    LinkedList<Coord> queue;
    int result;
    int[][] dp;

    class Coord{
        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int x;
        int y;

    }

    void BFS(Coord e,int m,int n,int[][] map){
        int x=e.x;
        int y=e.y;
        if(x+1<m){
            if(dp[x+1][y]>dp[x][y]+map[x+1][y]){
                dp[x+1][y]=dp[x][y]+map[x+1][y];
                queue.add(new Coord(x+1,y));
            }
        }
        if(y+1<n){
            if(dp[x][y+1]>dp[x][y]+map[x][y+1]){
                dp[x][y+1]=dp[x][y]+map[x][y+1];
                queue.add(new Coord(x,y+1));
            }
        }

    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        if(m==0)return 0;
        int n=grid[0].length;
        dp=new int[m][n];
        result=0;
        dp=new int[m][n];
        for (int i=0;i<m;i++)
            for(int j=0;j<n;j++)dp[i][j]=Integer.MAX_VALUE;

        queue=new LinkedList<>();
        dp[0][0]=grid[0][0];
        queue.add(new Coord(0,0));
        while(!queue.isEmpty()){
            BFS(queue.poll(),m,n,grid);
        }

        return dp[m-1][n-1];

    }
}