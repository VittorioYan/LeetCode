import java.util.Arrays;

class Solution31 {
    public void nextPermutation(int[] nums) {
        int n=nums.length;


        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                for(int j=i+1;j<n;j++) {
                    if (nums[j] <= nums[i]) {
                        int temp;
                        temp = nums[i];
                        nums[i] = nums[j - 1];
                        nums[j - 1] = temp;
                        Arrays.sort(nums, i + 1, n);
                        return;
                    }
                }
                    int temp;
                    temp=nums[i];
                    nums[i]=nums[n-1];
                    nums[n-1]=temp;
                    Arrays.sort(nums,i+1,n);
                    return;


            }
            if(i==0){
                Arrays.sort(nums);
                return;
            }

        }

    }
}