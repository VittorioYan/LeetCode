import java.util.HashMap;
import java.util.Map;

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> flagMap=new HashMap();
        int[] result =new int[2];
        for (int i=0;i<nums.length;i++) {
            if(flagMap.containsKey(nums[i])){
                result[0]=flagMap.get(nums[i]);
                result[1]=i;
                return result;
            }
            flagMap.put(target-nums[i],i);
            
        }
        return result;
    }
}