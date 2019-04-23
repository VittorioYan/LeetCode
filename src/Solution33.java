class Solution33 {
    int result;
    public void find(int l,int r,int target,int[] nums){
        int point=l+((r-l)>>1);
        if(nums[point]==target){
            result=point;
            return;
        }
        if(nums[l]==target){
            result=l;
            return;
        }
        if(l==point){
            if(nums[r]==target){
                result=r;
            }
            return;
        }
        if(result==-1){
            if(nums[l]<nums[point]){
                if(target>nums[point]){
                    find(point,r,target,nums);
                }
                else {
                    if(target<nums[l]){
                        find(point,r,target,nums);
                    }
                    else {
                        find(l,point,target,nums);
                    }
                }
            }
            else {
                if(target>nums[l]){
                    find(l,point,target,nums);
                }
                else {
                    if(target<nums[point]){
                        find(l,point,target,nums);
                    }
                    else {
                        find(point,r,target,nums);
                    }
                }
            }
        }

    }

    public int search(int[] nums, int target) {
        result=-1;
        if(nums.length==0)return -1;
        find(0,nums.length-1,target,nums);

        return result;

    }
}