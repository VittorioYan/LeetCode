class Solution28 {
    public int strStr(String haystack, String needle) {
        int haystackLen=haystack.length();
        int needleLen=needle.length();
        if(needleLen==0)return 0;
        if(haystackLen==0)return -1;
        char[] t=haystack.toCharArray();
        char[] p=needle.toCharArray();
        int[] next=new int[needleLen];
        forNext(next,p);

        int i=0,j=0;

          while (i < t.length && j < p.length) {

                 if (j == -1 || t[i] == p[j]) { // 当j为-1时，要移动的是i，当然j也要归0

                        i++;

                        j++;

                    } else {

                        // i不需要回溯了

                          // i = i - j + 1;

                       j = next[j]; // j回到指定位置
                 }

           }

       if (j == p.length) {

             return i - j;

            } else {

                 return -1;

            }




    }

    public void forNext(int[] next,char[] p){
        int j=0,k=-1;
        int n=p.length;
        next[0]=-1;

        while (j<n-1){
            if(k==-1||p[j]==p[k]){
                if(p[++j]==p[++k]){
                    next[j]=next[k];
                }
                else {
                    next[j]=k;
                }
            }
            else k=next[k];
        }
    }
}