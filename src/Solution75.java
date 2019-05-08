class Solution75 {
    void exchange(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    public void sortColors(int[] nums) {
        int len=nums.length;
        if(len==0)return;
        int point0=0;
        int point2=len-1;
        int point=0;
        while(point<=point2){
            if(nums[point]==0&&point>point0){
                exchange(nums,point,point0);
                point0++;
                continue;
            }
            if (nums[point]==2){
                exchange(nums,point,point2);
                point2--;
                continue;
            }
            point++;
        }

    }
}