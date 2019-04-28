class Solution44_overtime {
    public boolean isMatch(String s, String p) {
        if(s==null||p==null)return false;
        p=p.replaceAll("\\*+","*");

        char[] sChar=s.toCharArray();
        char[] pChar=p.toCharArray();

        return dp(sChar,pChar,0,0);

    }

    boolean dp(char[] s,char[] p,int sIndex,int pIndex) {
        int sLen = s.length;
        int pLen = p.length;
        if (pIndex == pLen) return sIndex == sLen;
        if (p[pIndex] == '*') {
            if(sLen==sIndex)return dp(s, p, sIndex, pIndex + 1);
            else return dp(s, p, sIndex + 1, pIndex) || dp(s, p, sIndex + 1, pIndex + 1) || dp(s, p, sIndex, pIndex + 1);
        }
        if (sIndex==sLen) return pIndex==pLen;
        if (s[sIndex] == p[pIndex] || p[pIndex] == '?') return dp(s, p, sIndex + 1, pIndex + 1);

        return false;
    }
}