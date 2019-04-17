class Solution7 {
    public int reverse(int x) {
        int result=0;
        String resString="";
        boolean flag=false;
        if(x<0){
            flag=true;
        }
        x=Math.abs(x);
        String s=x+"";
        for(int i=s.length()-1;i>=0;i--){
            resString+=s.charAt(i);
        }
        try {
            result=Integer.valueOf(resString).intValue();
        }catch (Exception e){
            return 0;
        }

        if(flag)
            result=0-result;


        return result;

    }
}