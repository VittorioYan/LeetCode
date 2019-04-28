class Solution44_handsome {
    public boolean isMatch(String s, String p) {
        if(s==null||p==null)return false;
        p=p.replaceAll("\\*+","*");
        char[] sChar=s.toCharArray();
        char[] pChar=p.toCharArray();
        int sLen=s.length();
        int pLen=p.length();
        boolean[][] dp=new boolean[sLen+1][pLen+1];
        dp[0][0]=true;
        for(int i=0;i<=sLen;i++){
            for (int j=1;j<=pLen;j++){
                if(pChar[j-1]=='*'){
                    dp[i][j]=dp[i][j-1]||(i>0&&dp[i-1][j]);
                }
                else dp[i][j]=i>0&&(sChar[i-1]==pChar[j-1]||pChar[j-1]=='?')&&dp[i-1][j-1];
            }
        }


        return dp[sLen][pLen];
    }

}