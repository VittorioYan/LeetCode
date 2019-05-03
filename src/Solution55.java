class Solution55 {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        if(n==0)return false;
        int point=0,max=nums[0];
        while (point<=max&&point<n){
            max=Math.max(max,point+nums[point]);
            if(max>=n-1)return true;
            point++;
        }
        return false;

    }
}