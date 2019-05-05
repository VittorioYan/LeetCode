import java.util.LinkedList;

class Solution62 {
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


//    void DFS(int x,int y,int m,int n){
//        if(x>=m||y>=n)return;
//        if(x==m-1&&y==n-1){
//            result++;
//            return;
//        }
//        DFS(x+1,y,m,n);
//        DFS(x,y+1,m,n);
//    }
    void BFS(Coord e,int m,int n){
        int x=e.x;
        int y=e.y;
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

    public int uniquePaths(int m, int n) {
        result=0;
        dp=new int[m][n];
        if(m==0||n==0)return 0;
        queue=new LinkedList<>();
        dp[0][0]=1;

        queue.add(new Coord(0,0));
        while(!queue.isEmpty()){
            BFS(queue.poll(),m,n);
        }

        return dp[m-1][n-1];

    }
}