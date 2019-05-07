class Solution70 {
    public int climbStairs(int n) {
        int[] result=new int[n+1];
        result[0]=1;
        for(int i=0;i<=n;i++){
            if(i+1<=n)result[i+1]+=result[i];
            if(i+2<=n)result[i+2]+=result[i];
        }
        return result[n];


    }
}