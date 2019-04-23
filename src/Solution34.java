class Solution34 {
    int result;

    public void find(int l,int r,int target,int nums[]){
        int point=l+((r-l)>>1);
        if(target==nums[point]){
            result=point;
            return;
        }
        if(target==nums[r]){
            result=r;
            return;
        }
        if(r-l<=1)return;
        if(result==-1){
            if(target<nums[point]){
                find(l,point,target,nums);
            }
            else {
                find(point,r,target,nums);
            }
        }

    }


    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int[] resultIndex=new int[2];
        resultIndex[0]=-1;
        resultIndex[1]=-1;
        if(n==0)return resultIndex;
        result=-1;
        find(0,n-1,target,nums);

        if(result==-1){
            return resultIndex;
        }
        for(int i=result;i<n;i++)
            if(nums[i]==target){
            resultIndex[1]=i;
            }else break;
        for(int i=result;i>=0;i--)
            if(nums[i]==target){
                resultIndex[0]=i;
            }else break;


        return resultIndex;



    }
}