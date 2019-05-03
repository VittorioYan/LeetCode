class Solution59 {
    int[][] result;
    int temp;

    void outPut(int leftI,int leftJ,int rightI,int rightJ){
        if(leftI>rightI||leftJ>rightJ)return;
        for(int j=leftJ;j<=rightJ;j++)result[leftI][j]=++temp;
        for(int i=leftI+1;i<=rightI;i++)result[i][rightJ]=++temp;
        if(leftI<rightI)
            for(int j=rightJ-1;j>=leftJ;j--)result[rightI][j]=++temp;
        if(leftJ<rightJ)
            for(int i=rightI-1;i>leftI;i--)result[i][leftJ]=++temp;
        outPut(leftI+1,leftJ+1,rightI-1,rightJ-1);

    }

    public int[][] generateMatrix(int n) {
        result=new int[n][n];
        temp=0;
        outPut(0,0,n-1,n-1);

        return result;

    }
}