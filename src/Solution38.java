class Solution38 {
    public String countAndSay(int n) {
        String countSay;
        String newSay="";
        countSay="1";
        char count;
        int num;
        int point;
        for(int i=1;i<n;i++){
            count=countSay.charAt(0);
            num=0;
            point=0;
            while(point<countSay.length()){
                if(count==countSay.charAt(point)){
                    num++;
                }
                else{
                    newSay+=String.valueOf(num);
                    newSay+=count;
                    num=1;
                    count=countSay.charAt(point);
                }
                point++;
            }
            newSay+=String.valueOf(num);
            newSay+=count;
            countSay=newSay;
            newSay="";
        }
        return countSay;

    }
}