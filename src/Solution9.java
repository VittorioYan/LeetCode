class Solution9 {
    public boolean isPalindrome(int x) {
        if(x<0)return false;
        if(x<10)return true;
        if(x%10==0)return false;
        int origin=x;
        int reverse=0;
        while(origin>0){
            reverse=reverse*10+origin%10;
            origin/=10;
        }
        if(reverse==x)return true;
        return false;

    }
}