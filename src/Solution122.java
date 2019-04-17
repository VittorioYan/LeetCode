class Solution122 {
    public int maxProfit(int[] prices) {
        int result=0;
        int left=0,right;
        boolean sellFlag=true;//true:need buy;false:need sell
        for(int i=0;i<prices.length-1;i++){
            if(prices[i]<prices[i+1]){
                if(sellFlag){
                    sellFlag=false;
                    left=prices[i];
                }
            }
            if(prices[i]>=prices[i+1]){
                if(!sellFlag){
                    sellFlag=true;
                    result+=prices[i]-left;

                }
            }
        }
        if(!sellFlag)result+=prices[prices.length-1]-left;
        return result;


    }


}