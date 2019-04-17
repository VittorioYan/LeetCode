import java.util.Arrays;

class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length<3)return 0;

        Arrays.sort(nums);
        int result=0;
        int n=nums.length;
        int minDistense=2147483647;
        for(int i=0;i<n;i++){
            int l=i+1;
            int r=n-1;
            while(l<r){

                if(nums[l]+nums[i]+nums[r]<target){
                    if(minDistense>target-(nums[l]+nums[i]+nums[r])){
                        result=nums[l]+nums[i]+nums[r];
                        minDistense=target-result;
                    }
                    l++;
                }
                else if (nums[l]+nums[i]+nums[r]>target){
                    if(minDistense>(nums[l]+nums[i]+nums[r])-target){
                        result=nums[l]+nums[i]+nums[r];
                        minDistense=result-target;
                    }
                    r--;
                }
                else return target;
            }
        }




        return result;

    }
}