class Solution87 {
    boolean[][][] isScramS;
    boolean[][][] isChange;

    boolean isScram(String s1,String s2,int s1P,int s2P,int pLen){
        if(isChange[s1P][s2P][pLen])return isScramS[s1P][s2P][pLen];
        if(pLen==0)return false;
        isChange[s1P][s2P][pLen]=true;
        if(pLen==1){
            if(s1.charAt(s1P)==s2.charAt(s2P)){
                isScramS[s1P][s2P][pLen]=true;
                return true;
            }else return false;
        }
        if(pLen==2){
            if(s1.charAt(s1P)==s2.charAt(s2P)&&s1.charAt(s1P+1)==s2.charAt(s2P+1)||
                s1.charAt(s1P)==s2.charAt(s2P+1)&&s1.charAt(s1P+1)==s2.charAt(s2P)){
                isScramS[s1P][s2P][pLen]=true;
                return true;
            }else return false;
        }
        for(int i=1;i<=pLen-1;i++){
            if((isScram(s1,s2,s1P,s2P,i)&&isScram(s1,s2,s1P+i,s2P+i,pLen-i))||
                    (isScram(s1,s2,s1P,s2P+pLen-i,i)&&isScram(s1,s2,s1P+i,s2P,pLen-i))){
                isScramS[s1P][s2P][pLen]=true;
                return true;
            }
        }
        return false;




    }

    public boolean isScramble(String s1, String s2) {
        if(s1==null||s2==null)return false;
        int lenS1=s1.length();
        int lenS2=s2.length();
        if(lenS1==0)return false;
        if(lenS1!=lenS2)return false;

        isChange=new boolean[lenS1+1][lenS1+1][lenS1+1];
        isScramS=new boolean[lenS1+1][lenS1+1][lenS1+1];

        return isScram(s1,s2,0,0,lenS1);

    }
}