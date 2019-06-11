import java.util.List;

class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int lSize=triangle.size();
        int[] resultDP=new int[lSize];
        List<Integer> temp=triangle.get(lSize-1);
        for(int i=0;i<lSize;i++)resultDP[i]=temp.get(i);
        for(int i=lSize-2;i>=0;i--){
            temp=triangle.get(i);
            for(int j=0;j<=i;j++){
                resultDP[j]=Integer.min(resultDP[j],resultDP[j+1])+temp.get(j);

            }
        }
        return resultDP[0];

    }
}