class Solution123 {
    public int maxProfit(int[] prices) {
        int result=0;
        int n=prices.length;
        if (n==0)return 0;
        int[] minGroup=new int[n];
        int minNum=prices[0];
        for (int i=1;i<n;i++){
            if(prices[i]-minNum>minGroup[i-1]){
                minGroup[i]=prices[i]-minNum;
            }else minGroup[i]=minGroup[i-1];
            minNum=Math.min(minNum,prices[i]);
            //System.out.println("Left : "+minGroup[i]);
        }
        int[] maxGroup=new int[n];
        int maxNum=prices[n-1];
        for (int i=n-2;i>=0;i--){
            if(maxNum-prices[i]>maxGroup[i+1]){
                maxGroup[i]=maxNum-prices[i];
            }else maxGroup[i]=maxGroup[i+1];
            maxNum=Math.max(maxNum,prices[i]);
            //System.out.println("Right : "+maxGroup[i]);
        }
        result=0;
        for (int i=0;i<n;i++){
            result=Math.max(result,minGroup[i]+maxGroup[i]);
            System.out.println(result);
        }

        return result;

    }


}