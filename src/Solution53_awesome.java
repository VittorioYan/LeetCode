class Solution53_awesome {
    public int maxSubArray(int[] nums) {
//        int result=nums[0];
//        int max=result;
//
//        for(int i=1;i<nums.length;i++){
//            if(nums[i]<result+nums[i])result=result+nums[i];
//            else result=nums[i];
//            max=Math.max(result,max);
//
//        }
//
//        return max;
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(res, sum);
        }
        return res;


    }
}