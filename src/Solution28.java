class Solution28 {
    public int strStr(String haystack, String needle) {
        int haystackLen=haystack.length();
        int needleLen=needle.length();
        if(needleLen==0)return 0;
        if(haystackLen==0)return -1;
        char[] haystackChar=haystack.toCharArray();
        char[] needleChar=needle.toCharArray();
        int[] next=new int[needleLen];
        forNext(next,needle);
        int pointNeedle=0;
        int pointHay=0;

        while (pointHay<haystackLen){
            if(haystackChar[pointHay]==needleChar[pointNeedle]){
                if(pointNeedle==needleLen-1)return pointHay-needleLen+1;
                pointHay++;
                pointNeedle++;

            }
            else {
                pointNeedle=next[pointNeedle];
                if(pointNeedle==-1){
                    pointHay++;
                    pointNeedle++;
                }
            }

        }


        return -1;

    }

    public void forNext(int[] next,char[] pattern){
        int j=1,k=-1;
        int n=pattern.length;
        next[0]=-1;

        while (j<n){
            if(k==-1||pattern[j]==pattern[k]){
                k++;

                next[j]=k;
                j++;
            }
            else k=next[k];
        }
    }
}