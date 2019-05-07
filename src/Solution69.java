class Solution69 {
    public int mySqrt(int x) {
        if(x<=1)return x;
        double a=4;
        double old=0;
        while(Math.abs((a+x/a)/2-old)>0.00001){
            old=(a+x/a)/2;
            a=old;
        }
        return (int)a;

    }
}