class Solution26 {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0)return 0;
        int result=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]) {
                nums[result+1]=nums[i];
                result++;
            }
        }

        return result+1;

    }
}