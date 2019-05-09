import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class Solution78 {
    List<List<Integer>> result;
    void addNum(int[] nums,String isExist){
        List<Integer> temp=new ArrayList<>();
        while (isExist.length()<nums.length)isExist="0"+isExist;
        for(int i=0;i<nums.length;i++){
            if(isExist.charAt(i)=='1')temp.add(nums[i]);
        }
        result.add(temp);
    }
    public List<List<Integer>> subsets(int[] nums) {
        result=new ArrayList<>();
        int len=nums.length;
        int turns=1;
        for(int i=0;i<len;i++)turns=turns<<1;
        turns--;
        while(turns>=0){
            addNum(nums,Integer.toBinaryString(turns));
            turns--;
        }

        return result;

    }
}