import java.util.ArrayList;
import java.util.List;

class Solution54 {
    List<Integer> result;
    void outPut(int leftI,int leftJ,int rightI,int rightJ,int[][] matrix){
        if(leftI>rightI||leftJ>rightJ)return;
        for(int j=leftJ;j<=rightJ;j++)result.add(matrix[leftI][j]);
        for(int i=leftI+1;i<=rightI;i++)result.add(matrix[i][rightJ]);
        if(leftI<rightI)
        for(int j=rightJ-1;j>=leftJ;j--)result.add(matrix[rightI][j]);
        if(leftJ<rightJ)
        for(int i=rightI-1;i>leftI;i--)result.add(matrix[i][leftJ]);
        outPut(leftI+1,leftJ+1,rightI-1,rightJ-1,matrix);

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        result=new ArrayList<>();
        int m=matrix.length;
        if(m==0)return result;
        int n=matrix[0].length;
        outPut(0,0,m-1,n-1,matrix);
        return result;

    }
}