class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result=0;
        int flag1=0,flag2=0;
        int flagRes=0;
        int x=0,y=0;
        double left=0,right=0;
        int aimTurn=nums1.length+nums2.length;
        boolean isTwoNum=false;
        if (aimTurn%2==0){
            isTwoNum=true;
        }
        aimTurn=aimTurn/2;
        while(flag1<nums1.length || flag2<nums2.length){
            if(flagRes>aimTurn)break;
            if(flag1<nums1.length){
                x=nums1[flag1];
            }
            else x=2147483647;
            if(flag2<nums2.length){
                y=nums2[flag2];
            }
            else y=2147483647;
            if(x>y){
                flag2++;
                if(flagRes==aimTurn-1)left=y;
                if(flagRes==aimTurn)right=y;
            }
            else{
                flag1++;
                if(flagRes==aimTurn-1)left=x;
                if(flagRes==aimTurn)right=x;
            }

            flagRes++;
        }
        if(isTwoNum){
            result=(left+right)/2;
        }
        else result=right;


        return result;

    }
}