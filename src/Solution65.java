//弱智题，啥也不说清楚，.1和01都能true咋不去死
//但是这个分治法肯定效率极高，预计应该在3ms以内

class Solution65 {
    boolean isNum(String s,boolean sign,boolean canNull){
        int n=s.length();
        if(n==0){
            if(canNull)return true;
            else return false;
        }
        if(s.charAt(0)=='+'||s.charAt(0)=='-'){
            if(!sign)return false;
            s=s.substring(1);
            n=s.length();
            if(n==0)return false;
        }
        if(n>1&&s.charAt(0)=='0')return false;
        for(int i=0;i<n;i++){
            if(s.charAt(i)>'9'||s.charAt(i)<'0')return false;
        }
        return true;

    }
    boolean isDotNum(String s){
        int dotFlag=s.indexOf('.');
        int n=s.length();
        if(dotFlag>=0){
            return isNum(s.substring(0,dotFlag),true,true)&&isNum(s.substring(dotFlag+1,n),false,false);
        }else return isNum(s,true,false);
    }

    public boolean isNumber(String s) {
        s=s.trim();
        int n=s.length();
        int eFlag=s.indexOf('e');
        if(eFlag>0){
            return isDotNum(s.substring(0,eFlag))&&isDotNum(s.substring(eFlag+1,n));
        }else return isDotNum(s);

    }
}