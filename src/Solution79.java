class Solution79 {
    boolean DFS(char[][] board,char[] word,int point,int x,int y,boolean[][] flagMap){
        if(point==word.length-1)return true;
        flagMap[x][y]=true;
        int m=board.length;
        int n=board[0].length;
        boolean result=false;
        if(x-1>=0&&board[x-1][y]==word[point+1]&&!flagMap[x-1][y]){
            result=DFS(board,word,point+1,x-1,y,flagMap);
            if (result)return true;
        }
        if(y-1>=0&&board[x][y-1]==word[point+1]&&!flagMap[x][y-1]){
            result=DFS(board,word,point+1,x,y-1,flagMap);
            if (result)return true;
        }

        if(x+1<m&&board[x+1][y]==word[point+1]&&!flagMap[x+1][y]){
            result=DFS(board,word,point+1,x+1,y,flagMap);
            if (result)return true;
        }

        if(y+1<n&&board[x][y+1]==word[point+1]&&!flagMap[x][y+1]){
            result=DFS(board,word,point+1,x,y+1,flagMap);
            if (result)return true;
        }

        flagMap[x][y]=false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int m=board.length;
        if(m==0)return false;
        int n=board[0].length;
        if(n==0)return false;
        if(word.length()==0)return false;
        char[] chars=word.toCharArray();

        boolean[][] flagMap=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(DFS(board,chars,0,i,j,flagMap))return true;
                }
            }
        }

        return false;

    }
}