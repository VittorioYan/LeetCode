class Solution42 {
    int water(int[] nums,int l,int r,int h){
        int result=0;
        for(int i=l+1;i<r;i++){
            result+=h-nums[i];
        }
        return result;
    }
    public int trap(int[] height) {
        int result=0;
        if(height.length==0)return 0;
        int maxheight=height[0];
        int maxPoint=0;
        for(int i=1;i<height.length;i++){
            if(height[i]>=maxheight){
                if(maxheight>0){
                    result+=water(height,maxPoint,i,maxheight);
                }
                maxheight=height[i];
                maxPoint=i;

            }
        }
        int mid=maxPoint;
        maxheight=height[height.length-1];
        maxPoint=height.length-1;
        for(int i=height.length-1;i>=mid;i--){
            if(height[i]>=maxheight){
                if(maxheight>0){
                    result+=water(height,i,maxPoint,maxheight);
                }
                maxheight=height[i];
                maxPoint=i;

            }
        }


        return result;

    }
}