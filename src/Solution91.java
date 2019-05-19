class Solution91 {
    int result;
    void calcul(char[] chars,int len,int point){
        if(point>len)return;
        if(point==len){
            result++;
            return;
        }
        if(chars[point]=='0')return;
        if(chars[point]=='1'){
            calcul(chars,len,point+2);
        }
        if(chars[point]=='2'){
            if(point+1<len&&chars[point+1]<='6')calcul(chars,len,point+2);
        }
        calcul(chars,len,point+1);

    }

    public int numDecodings(String s) {
        result=0;
        int len=s.length();
        char[] chars=s.toCharArray();
        calcul(chars,len,0);

        return result;

    }
}