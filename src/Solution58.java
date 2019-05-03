class Solution58 {
    public int lengthOfLastWord(String s) {
        int result=0;
        boolean wordFlag=false;
        for(int i=s.length()-1;i>=0;i--){
            if(wordFlag){
                if(s.charAt(i)!=' '){
                    result++;
                    continue;
                }
                else break;
            }
            if(s.charAt(i)!=' '){
                wordFlag=true;
                result++;
            }

        }

        return result;

    }
}