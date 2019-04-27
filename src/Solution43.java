class Solution43 {

    String addStr(String str1,String str2){
        String result="";
        int len1=str1.length();
        int len2=str2.length();
        int num1;
        int num2;
        int num;
        short flag=0;
        while(len1-1>=0||len2-1>=0||flag!=0){
            if(len1-1>=0)num1=str1.charAt(len1-1)-'0';
            else num1=0;
            if(len2-1>=0)num2=str2.charAt(len2-1)-'0';
            else num2=0;
            num=num1+num2+flag;
            if(num>=10){
                num=num-10;
                flag=1;
            }else flag=0;
            result=num+result;
            len1--;
            len2--;
        }

        return result;
    }
    String multiOne(String str,char multi){
        String result="";
        int flag=0;
        int num;
        for(int i=str.length()-1;i>=0;i--){
            num=(str.charAt(i)-'0')*(multi-'0')+flag;
            flag=num/10;
            num=num%10;
            result=num+result;
        }
        if(flag!=0)
        return flag+result;
        else return result;
    }

    public String multiply(String num1, String num2) {
        String result="0";
        if(num1.equals("0")||num2.equals("0"))return "0";
        String num;
        for(int i=num1.length()-1;i>=0;i--){
            num=multiOne(num2,num1.charAt(i));
            for(int j=num1.length()-1;j>i;j--)num=num+'0';
            result=addStr(result,num);

        }


        return result;

    }
}