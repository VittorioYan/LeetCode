class Solution45 {
    public int jump(int[] nums) {
        int n=nums.length;
        int[] maxIndex=new int[n];
        for(int i=0;i<n;i++){
            maxIndex[i]=i+nums[i];
        }
        int aim=n-1;
        int point=0;
        int step=0;
        while(aim>0&&point<n){
            if(maxIndex[point]>=aim){
                aim=point;
                point=0;
                step++;
                continue;
            }
            point++;

        }
        return step;
//DP overtime
//        int n=nums.length;
//        int[] dp=new int[n];
//        for(int i=1;i<n;i++){
//            dp[i]=Integer.MAX_VALUE;
//        }
//        for(int i=0;i<n;i++){
//            for(int j=1;j<=nums[i];j++){
//                if(i+j<n)
//                dp[i+j]=Math.min(dp[i+j],dp[i]+1);
//            }
//        }
//        return dp[n-1];

    }
}