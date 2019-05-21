class Solution97 {
    int[][] dpRec;


    boolean dp(String s1, String s2, String s3,int point1,int point2){
        int point3=point1+point2;
        if(point3==s3.length()){
            dpRec[point1][point2]=1;
            return true;
        }
        boolean a=false,b=false;
        if(point1<s1.length()&&s3.charAt(point3)==s1.charAt(point1)){
            if(dpRec[point1+1][point2]!=0){
                a=dpRec[point1+1][point2]>0;
            }
            else a=dp(s1,s2,s3,point1+1,point2);
        }
        if(point2<s2.length()&&s3.charAt(point3)==s2.charAt(point2)){
            if(dpRec[point1][point2+1]!=0){
                a=dpRec[point1][point2+1]>0;
            }
            b=dp(s1,s2,s3,point1,point2+1);
        }
        if(a||b)dpRec[point1][point2]=1;
        else dpRec[point1][point2]=-1;
        return a||b;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int s1Len=s1.length();
        int s2Len=s2.length();
        int s3Len=s3.length();
        if(s1Len+s2Len!=s3Len)return false;
        dpRec=new int[s1Len+1][s2Len+1];


        return dp(s1,s2,s3,0,0);

    }
}