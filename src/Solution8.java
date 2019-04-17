class Solution8 {
    public int myAtoi(String str) {
        if(str.isEmpty())return 0;
        int n=str.length();
        String resString;
        int result;
        boolean flag=false;
        boolean isChange=false;
        int left=0,right=0;
        for (int i=0;i<n;i++){
            if(str.charAt(i)==' ')continue;
            if (str.charAt(i)=='-'||str.charAt(i)=='+'||str.charAt(i)>='0'||str.charAt(i)<='9'){
                if(i+1<n&&(str.charAt(i)=='-'||str.charAt(i)=='+'))i++;
                if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                    left=i;
                    isChange=true;
                    while(i<n&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
                        i++;
                    }
                    right=i-1;
                    break;
                }
                else return 0;

            }else return 0;

        }
        if(left>0&&str.charAt(left-1)=='-')flag=true;
        if(isChange) {
            resString=str.substring(left,right+1);
        }
        else return 0;
        try {
            result=Integer.valueOf(resString).intValue();
        }catch (Exception e){
            if(flag)return -2147483648;
            else return 2147483647;
        }
        if(flag)result=0-result;
        return result;


    }
}