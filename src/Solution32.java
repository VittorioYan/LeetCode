class Solution32 {
    public int longestValidParentheses(String s) {
        int result=0;
        int n=s.length();
        int minFlag=n;
        int nowMax=0;
        int index=0;
        int[] bracketNum=new int[n];
        int bracketsPoint=s.indexOf("()");
        while(bracketsPoint!=-1){
            if(bracketsPoint<=minFlag){
                minFlag=bracketsPoint;
                nowMax+=2;

            }
            else{
                result=result>nowMax?result:nowMax;
                nowMax=0;
                minFlag=bracketsPoint;
                continue;
            }
            s=s.replaceFirst("\\(\\)","");
            bracketsPoint=s.indexOf("()");
        }
        result=result>nowMax?result:nowMax;


        return result;


    }
}