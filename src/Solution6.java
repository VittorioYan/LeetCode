class Solution6 {
    public String convert(String s, int numRows) {
        if(s.isEmpty()||numRows==1)return s;
        String result="";
        int n=s.length();
        int xPointer=0,yPointer=0;
        boolean direction=false;//true:右上;false:下
        char[][] zMap=new char[numRows][n/2+1];
        for (int i=0;i<n;i++){
            zMap[xPointer][yPointer]=s.charAt(i);
            if (xPointer==numRows-1)direction=true;
            if (xPointer==0)direction=false;
            if(!direction){
                xPointer++;
            }
            else {
                xPointer--;
                yPointer++;
            }


        }
        for (int i=0;i<numRows;i++){
            for (int j=0;j<n/2+1;j++){
                if(zMap[i][j]>0){
                    result+=zMap[i][j];
                    System.out.println(zMap[i][j]);
                }

            }
        }
        return result;

    }
}