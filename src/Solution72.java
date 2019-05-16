class Solution72 {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        char[] s1=word1.toCharArray();
        char[] s2=word2.toCharArray();
        int[][] dp=new int [m+1][n+1];
        for(int i=0;i<=m;i++)dp[i][0]=i;
        for(int j=0;j<=n;j++)dp[0][j]=j;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                int a1;
                if(s1[i-1]==s2[j-1])a1=dp[i-1][j-1];
                else a1=dp[i-1][j-1]+1;
                dp[i][j]=Integer.min(Integer.min(a1,dp[i-1][j]+1),dp[i][j-1]+1);
            }
        }
        return dp[m][n];

    }
}