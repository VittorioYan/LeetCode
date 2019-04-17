class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        String longStr="";
        int pointer=0;
        boolean flag=false;
        try {
            while(true){
                for(int i=0;i<strs.length;i++){
                    if(strs[i].charAt(pointer)!=strs[0].charAt(pointer)){
                        flag=true;
                        break;
                    }
                }
                if(flag)break;
                longStr+=strs[0].charAt(pointer);
                pointer++;
            }

        }catch (Exception e){
            return longStr;
        }
        return longStr;

    }
}