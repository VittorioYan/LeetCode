class Solution5 {

    public String longestPalindrome(String s) {
        int n=s.length();
        if(s.isEmpty())return s;
        int[][] dp=new int[n][n];
        boolean[][] flag=new boolean[n][n];
        String result="";
        int left=0,right=0;
        for(int i=0;i<s.length();i++){
            dp[i][i]=1;
            flag[i][i]=true;
        }

        for(int j=0;j<s.length();j++){
            for (int i=j-1;i>=0;i--){
                if(s.charAt(i)==s.charAt(j)&&(flag[i+1][j-1]||j-i<3)){
                    dp[i][j]=dp[i+1][j-1] + 2;
                    flag[i][j]=true;
                    if(j-i>right-left){
                        left=i;
                        right=j;
                    }

                }
                else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }

            }
        }
        System.out.println(left);
        System.out.println(right);
        result=s.substring(left,right+1);

        return result;

    }
}