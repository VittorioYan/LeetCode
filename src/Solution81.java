class Solution81 {
    boolean find(int l,int r,int target,int[] nums){
        int nowPoint=l+(r-l)/2;
        if(target==nums[l]||target==nums[r]||target==nums[nowPoint])return true;
        if(r-l<=1)return false;
        if(nums[nowPoint]==nums[l]&&nums[nowPoint]==nums[l])
                return find(l,nowPoint,target,nums)||find(nowPoint,r,target,nums);
        if(nums[nowPoint]==nums[l])return find(nowPoint,r,target,nums);
        if(nums[nowPoint]==nums[r])return find(l,nowPoint,target,nums);

        if(nums[l]<nums[nowPoint]){
            if(target>nums[nowPoint]){
                return find(nowPoint,r,target,nums);
            }
            else {
                if(target<nums[l]){
                    return find(nowPoint,r,target,nums);
                }
                else {
                    return find(l,nowPoint,target,nums);
                }
            }
        }
        else {
            if(target>nums[l]){
                return find(l,nowPoint,target,nums);
            }
            else {
                if(target<nums[nowPoint]){
                    return find(l,nowPoint,target,nums);
                }
                else {
                    return find(nowPoint,r,target,nums);
                }
            }
        }
    }



    public boolean search(int[] nums, int target) {
        if(nums==null)return false;
        int len=nums.length;
        if(len==0)return false;
        return find(0,len-1,target,nums);
    }
}