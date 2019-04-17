class Solution121 {
    public int maxProfit(int[] prices) {

        int n=prices.length;
        if (n==0)return 0;
        int[] maxNum=new int[n];
        int theMax=prices[n-1];
        for(int i=n-1;i>=0;i--){
            theMax=Math.max(theMax,prices[i]);
            maxNum[i]=theMax;
        }
        theMax=0;
        for (int i=0;i<n;i++){
            theMax=Math.max(theMax,maxNum[i]-prices[i]);
        }
        System.out.println(theMax);

        return theMax;

    }
}