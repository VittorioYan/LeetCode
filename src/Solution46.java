import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution46 {
    List<List<Integer>> dp(List<List<Integer>> origin,int num){
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<origin.size();i++){
            int len=origin.get(i).size();
            for(int j=0;j<=len;j++){
                List<Integer> temp=new ArrayList<>(origin.get(i));
                temp.add(j,num);

                result.add(temp);
            }
        }
        return result;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        if(nums.length==0)return result;
        temp.add(nums[0]);
        result.add(temp);
        for(int i=1;i<nums.length;i++){
            result=dp(result,nums[i]);
        }

        return result;


    }
}