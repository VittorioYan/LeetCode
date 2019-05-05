import java.util.LinkedList;

class Solution63 {
    int result;
    int[][] dp;
    LinkedList<Coord> queue;

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
        if(map[x][y]==1)return;
        if(x+1<m){
            if(dp[x+1][y]!=0){
                dp[x+1][y]=dp[x+1][y]+dp[x][y];
            }else {
                dp[x+1][y]=dp[x][y];
                queue.add(new Coord(x+1,y));
            }
        }
        if(y+1<n){
            if(dp[x][y+1]!=0){
                dp[x][y+1]=dp[x][y+1]+dp[x][y];
            }else {
                dp[x][y+1]=dp[x][y];
                queue.add(new Coord(x,y+1));
            }
        }

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        {
            int m=obstacleGrid.length;
            if(m==0)return 0;
            int n=obstacleGrid[0].length;
            if(obstacleGrid[0][0]==1||obstacleGrid[m-1][n-1]==1)return 0;

            result=0;
            dp=new int[m][n];
            queue=new LinkedList<>();
            dp[0][0]=1;

            queue.add(new Coord(0,0));
            while(!queue.isEmpty()){
                BFS(queue.poll(),m,n,obstacleGrid);
            }

            return dp[m-1][n-1];

        }


    }
}