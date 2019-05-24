class Solution87 {
    boolean isScram(String s1,String s2){
        int len=s1.length();
        if(len==1)return s1.equals(s2);
        if(len!=s2.length())return false;
        if(len%2!=0)
            return (isScram(s1.substring(0,len/2+1),s2.substring(len/2,len))&&
                isScram(s1.substring(len/2+1,len),s2.substring(0,len/2)))||
                (isScram(s1.substring(0,len/2+1),s2.substring(0,len/2+1))&&
                isScram(s1.substring(len/2+1,len),s2.substring(len/2+1,len)))||
               (isScram(s1.substring(0,len/2),s2.substring(0,len/2))&&
                 isScram(s1.substring(len/2,len),s2.substring(len/2,len)))||
                 (isScram(s1.substring(0,len/2),s2.substring(len/2+1,len))&&
                 isScram(s1.substring(len/2,len),s2.substring(0,len/2+1)));

        else return (isScram(s1.substring(0,len/2),s2.substring(0,len/2))&&
                isScram(s1.substring(len/2,len),s2.substring(len/2,len)))||
                (isScram(s1.substring(0,len/2),s2.substring(len/2,len))&&
                 isScram(s1.substring(len/2,len),s2.substring(0,len/2)));


    }

    public boolean isScramble(String s1, String s2) {
        if(s1==null||s2==null)return false;
        if(s1.length()==0)return false;
        return isScram(s1,s2);

    }
}