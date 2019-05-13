class Solution74 {
    int[] corresInex(int index,int n){
        int[] corres=new int[2];
        corres[0]=index/n;
        corres[1]=index%n;
        return corres;
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        if(m==0)return false;
        int n=matrix[0].length;
        if(n==0)return false;
        int left=0;
        int right=m*n-1;
        int index;
        int[] corres;
        if(matrix[0][0]==target||matrix[m-1][n-1]==target)return true;

        while (right-left>1){
            index=left+((right-left)>>1);
            corres=corresInex(index,n);
            if(matrix[corres[0]][corres[1]]==target)return true;
            if(matrix[corres[0]][corres[1]]>target){
                right=index;
            }else left=index;
        }


        return false;

    }
}