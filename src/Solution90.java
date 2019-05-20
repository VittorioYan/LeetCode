import java.util.ArrayList;
import java.util.List;

class Solution90 {
    List<Integer> num;
    List<Integer> count;
    List<List<Integer>> result;

    void dp(int point,List<Integer> route){

        if(point>=num.size()){
            result.add(new ArrayList<>(route));
            return;
        }
        int theNum=num.get(point);
        int theCount=count.get(point);
        List<Integer> midRoute=new ArrayList<>(route);

        for(int i=0;i<=theCount;i++){
            List<Integer> temp=new ArrayList<>(midRoute);
            dp(point+1,temp);
            midRoute.add(theNum);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        num=new ArrayList<>();
        count=new ArrayList<>();
        result=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int temp=num.indexOf(nums[i]);

            if(temp>=0){
                count.set(temp,count.get(temp)+1);
            }else {
                num.add(nums[i]);
                count.add(1);
            }
        }

        dp(0,new ArrayList<>());


        return result;

    }
}