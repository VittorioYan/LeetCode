class Solution87 {
    boolean isScram(String s1,String s2,int len){
        int lefrLen=len/2;
        String s1Left=s1.substring(0,lefrLen);
        String s1Right=s1.substring(lefrLen);
        String s2Left=s2.substring(0,lefrLen);
        String s2Right=s2.substring(lefrLen);
        boolean leftSame=s1Left.equals(s2Left);
        boolean rightSame=s1Right.equals(s2Right);
        boolean s1Ls2R=s1Left.equals(s2Right);


        if(!s1Left.equals(s2Left)&&!s1Right.equals(s2Right)){

        }

        return true;
    }

    public boolean isScramble(String s1, String s2) {
        int len1=s1.length();
        int len2=s2.length();
        if(len1==0||len2==0||len1!=len2)return false;



        return isScram(s1,s2,len1);

    }
}