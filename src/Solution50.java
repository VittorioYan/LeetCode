class Solution50 {
    double multiSelf(double x,int n){
        if(n==1)return x;
        double result=multiSelf(x,n/2);
        if(n%2==0){
            return result*result;
        }
        else return result*result*x;
    }
    public double myPow(double x, int n) {
        double flag=1;
        if(n==0)return 1;
        if(n<0){
            if(n==Integer.MIN_VALUE){
                n=Integer.MAX_VALUE;
                flag=x;
            }else n=0-n;
            return 1/(multiSelf(x,n)*flag);
        }


        return multiSelf(x,n);

    }
}