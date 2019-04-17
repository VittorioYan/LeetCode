class Solution11 {
    public static void shellSort(int[] data,int[] pos)
    {
        int j = 0;
        int temp = 0;
        int tempp=0;
        //每次将步长缩短为原来的一半
        for (int increment = data.length / 2; increment > 0; increment /= 2)
        {
            for (int i = increment; i < data.length; i++)
            {
                temp = data[i];
                tempp=pos[i];
                for (j = i; j >= increment; j -= increment)
                {
                    if(temp > data[j - increment])//如想从小到大排只需修改这里
                    {
                        data[j] = data[j - increment];
                        pos[j]=pos[j - increment];
                    }
                    else
                    {
                        break;
                    }

                }
                data[j] = temp;
                pos[j]=tempp;
            }

        }
    }

    public int maxArea(int[] height) {
        int n = height.length;
        int[] position=new int[n];
        for(int i=0;i<n;i++)position[i]=i+1;
        this.shellSort(height,position);
        int maxSqure=0;

        for (int i=0;i<n;i++){
            if (maxSqure>height[i]*n)break;
            for (int j=i;j>=0;j--){
                maxSqure=Math.max(maxSqure,height[i]*(Math.abs(position[i]-position[j])));
            }
        }
        System.out.println(maxSqure);

        return maxSqure;

    }

}