class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        int result=0;
        int max=0;
        char midChar;
        int head=0;
        boolean[] flag = new boolean[256];
        for(int i=0;i<s.length();i++){
            if(flag[s.charAt(i)]){
                {
                    for(int j=head;j<i;j++){
                        flag[s.charAt(j)]=false;
                        result--;
                        if(s.charAt(j)==s.charAt(i)){
                            head=j+1;
                            break;
                        }
                    }
                }

            }
            flag[s.charAt(i)]=true;
            result++;
            max=max>result?max:result;

        }

        return max;

    }
}