class Solution66 {
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

    public int[] plusOne(int[] digits) {
        String resultStr="";
        for(int i=0;i<digits.length;i++){
            resultStr+=Integer.toString(digits[i]);
        }
        resultStr=addStr(resultStr,"1");
        int n=resultStr.length();
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            result[i]=resultStr.charAt(i)-'0';
        }

        return result;

    }
}