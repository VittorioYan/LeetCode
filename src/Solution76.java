class Solution76 {
    public String minWindow(String s, String t) {
        String result="";
        int[] tHash=new int[64];
        int[] flagHash=new int[64];
        for(int i=0;i<t.length();i++){
            flagHash[t.charAt(i)-'A']++;
        }

        int tLen=t.length();
        int sLen=s.length();
        int accpt=0;
        int l=0,r=tLen;

        if(sLen<tLen)return result;

        for(int i=0;i<tLen;i++){
            int temp=s.charAt(i)-'A';
            if(flagHash[temp]>0){
                tHash[temp]++;
                if(tHash[temp]<=flagHash[temp]){
                    accpt++;
                }
            }

        }

        while (true){
            int winLen=r-l;
            if(winLen==tLen&&accpt==tLen){
                return s.substring(l,r);
            }
            if(r==sLen&&accpt!=tLen)break;

            if(winLen<=tLen){
                int temp=s.charAt(r)-'A';
                if(flagHash[temp]>0){
                    tHash[temp]++;
                    if(tHash[temp]<=flagHash[temp]){
                        accpt++;
                    }
                }
                r++;

            }else {
                if(accpt==tLen){
                    if(result.equals("")||result.length()>winLen)result=s.substring(l,r);
                    int temp=s.charAt(l)-'A';
                    if(flagHash[temp]>0){
                        tHash[temp]--;
                        if(tHash[temp]<flagHash[temp]){
                            accpt--;
                        }
                    }
                    l++;

                }else{
                    int temp=s.charAt(r)-'A';
                    if(flagHash[temp]>0){
                        tHash[temp]++;
                        if(tHash[temp]<=flagHash[temp]){
                            accpt++;
                        }
                    }
                    r++;
                }
            }





        }
        return result;



    }
}