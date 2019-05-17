class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        if(m==0)return 0;
        int n=matrix[0].length;
        if(n==0)return 0;
        int result=0;

        int[][] longOne=new int[m][n];
        int[] maxLine=new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    if(j>0)longOne[i][j]=longOne[i][j-1]+1;
                    else longOne[i][j]=1;
                }
            }
        }
        for (int j = 0; j < n; j++){
            result=Integer.max(result,longOne[0][j]);
            if(longOne[0][j]>0)maxLine[j]=1;
        }
        int temp;
        for(int i=1;i<m;i++) {
            for (int j = 0; j < n; j++) {
                if(longOne[i][j]>0){
                    maxLine[j]++;
                    if(longOne[i][j]>longOne[i-1][j])temp=longOne[i-1][j];
                    else temp=longOne[i][j];
                    result=Integer.max(result,maxLine[j]*temp);
                }
                else maxLine[j]=0;

            }
        }



        return result;

    }
}