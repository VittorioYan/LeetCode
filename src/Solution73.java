class Solution73 {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        if(m==0)return;
        int n=matrix[0].length;
        if(n==0)return;

        boolean row=false;
        boolean cloumn=false;

        for(int i=0;i<m;i++){
            if (matrix[i][0]==0){
                row=true;
                break;
            }
        }
        for(int j=0;j<n;j++){
            if (matrix[0][j]==0){
                cloumn=true;
                break;
            }
        }


        if(m>1&&n>1){
            for(int i=1;i<m;i++)
                for(int j=1;j<n;j++)
                    if(matrix[i][j]==0){
                        matrix[0][j]=0;
                        matrix[i][0]=0;
                    }
        }

        for(int i=1;i<m;i++){
            if(matrix[i][0]==0){
                for(int j=0;j<n;j++)matrix[i][j]=0;
            }
        }
        for(int j=1;j<n;j++){
            if(matrix[0][j]==0){
                for(int i=0;i<m;i++)matrix[i][j]=0;
            }
        }
        if(row){
            for(int i=0;i<m;i++)
                matrix[i][0]=0;
        }
        if (cloumn){
            for(int j=0;j<n;j++)
                matrix[0][j]=0;
        }



    }
}