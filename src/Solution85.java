class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        if(m==0)return 0;
        int n=matrix[0].length;
        if(n==0)return 0;
        int result=0;

        int[][] longOne=new int[m][n];
        int[][] maxLine=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    if(j>0)longOne[i][j]=longOne[i][j-1]+1;
                    else longOne[i][j]=1;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(longOne[i][j]>0){
                    int up=i,down=i;
                    while(up>=0&&longOne[up][j]>=longOne[i][j])up--;
                    while(down<m&&longOne[down][j]>=longOne[i][j])down++;
                    maxLine[i][j]=down-up-1;
                    result=Integer.max(result,maxLine[i][j]*longOne[i][j]);
                }
            }
        }
        return result;

    }
}