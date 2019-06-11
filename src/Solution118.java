import java.util.ArrayList;
import java.util.List;

class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        if(numRows==0)return result;
        List<Integer> temp=new ArrayList<>();
        temp.add(1);
        result.add(temp);
        if(numRows==1)return result;
        List<Integer> last;
        for(int i=2;i<=numRows;i++){
            temp=new ArrayList<>();
            last=result.get(i-2);
            for(int j=0;j<i;j++){
                if(j==0||j==i-1)temp.add(1);
                else temp.add(last.get(j)+last.get(j-1));
            }
            result.add(temp);
        }
        return result;

    }
}