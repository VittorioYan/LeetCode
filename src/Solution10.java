class Solution10 {
    public boolean isMatch(String s, String p) {
        if(s==null || p==null)return false;
        char[] sc=s.toCharArray();
        char[] pc=p.toCharArray();
        return dp(sc,pc,0,0);
    }
    boolean dp(char[] s,char[] p,int i,int j){
        int n=s.length;
        int m=p.length;
        if(j>=m) return i==n;
        //判断第一个字符匹配结果
        boolean j_match=i<n &&(s[i]==p[j] || p[j]=='.');
        if(j+1<m && p[j+1]=='*'){
            return dp(s,p,i,j+2)||(j_match &&dp(s,p,i+1,j));
        }
        return j_match && dp(s,p,i+1,j+1);
    }
}