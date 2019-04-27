class Solution41_handsome {
    public int firstMissingPositive(int[] nums) {
        //遍历一次数组把大于等于1的和小于数组大小的值放到原数组对应位置，
        //然后再遍历一次数组查当前下标是否和值对应，如果不对应那这个下标就是答案，否则遍历完都没出现那么答案就是数组长度加1。
        int n=nums.length;
        int temp;
        for(int i=0;i<n;i++){
            while (nums[i]>0&&nums[i]<=n&&nums[nums[i]-1]!=nums[i]){
                temp=nums[i];
                nums[i]=nums[nums[i]-1];
                nums[temp-1]=temp;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1)return i+1;
        }
        return n+1;
    }
}