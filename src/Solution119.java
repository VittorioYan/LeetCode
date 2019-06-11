import java.util.ArrayList;
import java.util.List;

class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        int[] result=new int[rowIndex+1];
        List<Integer> resultList=new ArrayList<>();
        if(rowIndex==0){
            resultList.add(1);
            return resultList;
        }
        int temp1=1;
        int temp2;
        for(int i=1;i<=rowIndex;i++){
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    result[j]=1;
                    temp1=1;
                }
                else {
                    temp2=result[j];
                    result[j]=result[j]+temp1;
                    temp1=temp2;
                }

            }
        }
        for(int i=0;i<=rowIndex;i++){
            resultList.add(result[i]);
        }
        return resultList;

    }
}