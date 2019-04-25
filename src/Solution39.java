import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution39 {
    List<List<Integer>> result;
    void dp(LinkedList<Integer> route,int target,int[] nums,int point){
        if(target==0){
            LinkedList<Integer> temp=new LinkedList<>();
            temp=route;
            result.add(temp);
            route.pollLast();
            return;
        }
        int n=nums.length;
        for(int i=point;i<n;i++){
            if(nums[i]<=target){
                LinkedList<Integer> temp=route;
                temp.add(nums[i]);
                dp(temp,target-nums[i],nums,i);
            }

        }
        route.pollLast();
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> theRoute=new LinkedList<>();
        result=new LinkedList<>();
        dp(theRoute,target,candidates,0);
        return result;



    }
}