class Solution67 {
    public String addBinary(String a, String b) {
        char[] aChar,bChar;
        aChar=a.toCharArray();
        bChar=b.toCharArray();
        int alen=aChar.length;
        int blen=bChar.length;
        int point=1;
        int flag=0;
        String result="";
        while(alen-point>=0||blen-point>=0||flag>0){
            int aPos;
            int bPos;
            if(alen-point<0)aPos=0;else aPos=aChar[alen-point]-'0';
            if(blen-point<0)bPos=0;else bPos=bChar[blen-point]-'0';
            int temp=flag+aPos+bPos;
            if(temp>1){
                flag=1;
                temp-=2;
            }else flag=0;
            result=temp+result;
            point++;
        }


        return result;

    }
}