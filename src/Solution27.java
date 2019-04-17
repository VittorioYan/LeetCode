class Solution27 {
    public int removeElement(int[] nums, int val) {
        int result=nums.length;
        if(nums.length==0)return 0;
        if(nums.length==1&&nums[0]==val)return 0;
        int left=0,right=nums.length-1;

        while(left<=right){
            while (right>=0&&nums[right]==val){
                result--;
                right--;
            }
            if(right<=left)break;
            while(left<right&&nums[left]!=val)left++;

            if(left!=right){
                nums[left]=nums[right];
                left++;
                right--;
                result--;
            }
        }

        return result;

    }
}