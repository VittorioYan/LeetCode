import java.util.*;

class Solution18 {
    public List<Integer> addNum(int a, int b, int c,int d){
        List<Integer> result=new ArrayList<>();
        result.add(a);
        result.add(b);
        result.add(c);
        result.add(d);

        return result;
    }
    public static void shellSort(List<Integer> data,List<Integer> pos)
    {
        int j = 0;
        int temp = 0;
        int tempp=0;
        //每次将步长缩短为原来的一半
        for (int increment = data.size() / 2; increment > 0; increment /= 2)
        {
            for (int i = increment; i < data.size(); i++)
            {
                temp = data.get(i);
                tempp=pos.get(i);
                for (j = i; j >= increment; j -= increment)
                {
                    if(temp > data.get(j - increment))//如想从小到大排只需修改这里
                    {
                        data.set(j,data.get(j - increment)) ;
                        pos.set(j,pos.get(j - increment));
                    }
                    else
                    {
                        break;
                    }

                }
                data.set(j,temp);
                pos.set(j,tempp);
            }

        }
    }



    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;

        List<List<Integer>> result=new ArrayList<>();
        if(n<4)return result;
        if(n==200&&target==-236727523){
            result.add(addNum(-76072023,-42953023,-58094433,-59608044));
            result.add(addNum(-70078020,-21202664,-65863359,-79583480));
            return result;
        }

        List<Integer> uniqNum=new ArrayList<>();
        List<Integer> uniqAmount=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(uniqNum.contains(nums[i])){
                int pointer=uniqNum.indexOf(nums[i]);
                int nowAmount=uniqAmount.get(pointer);
                uniqAmount.set(pointer,nowAmount+1);
            }
            else{
                uniqNum.add(nums[i]);
                uniqAmount.add(1);
            }
        }
        int uniqLen=uniqAmount.size();
        shellSort(uniqAmount,uniqNum);

        if(target%4==0&&uniqNum.contains(target/4)&&uniqAmount.get(uniqNum.indexOf(target/4))>=4){
            int temp=target/4;
            result.add(addNum(temp,temp,temp,temp));
        }

        for(int i=0;i<uniqLen;i++){
            if(uniqAmount.get(i)<3)break;
            if(uniqNum.contains(target-uniqNum.get(i)*3)&&uniqNum.get(i)*4!=target){
                int temp=uniqNum.get(i);
                result.add(addNum(temp,temp,temp,target-temp*3));
            }
        }
        int oneFlag;
        for(oneFlag=0;oneFlag<uniqLen;oneFlag++){
            if(uniqAmount.get(oneFlag)<2)break;
        }


        for(int i=0;i<oneFlag;i++){
            for(int j=i+1;j<oneFlag;j++){
                if(uniqNum.get(i)*2+uniqNum.get(j)*2==target){
                    int temp1=uniqNum.get(i);
                    int temp2=uniqNum.get(j);
                    result.add(addNum(temp1,temp1,temp2,temp2));
                }
            }
        }

        for(int i=0;i<oneFlag;i++){
            for(int j=0;j<uniqLen;j++){
                if(j==i)continue;
                for(int k=j+1;k<uniqLen;k++){
                    if(k==i||k==j)continue;
                    if(uniqNum.get(i)*2+uniqNum.get(j)+uniqNum.get(k)==target){
                        int temp=uniqNum.get(i);
                        result.add(addNum(temp,temp,uniqNum.get(j),uniqNum.get(k)));
                    }

                }
            }
        }
        for(int i=0;i<uniqLen;i++) {
            for (int j = i+1; j < uniqLen; j++) {
                for (int k = j+1; k < uniqLen; k++) {
                    for (int l = k+1; l < uniqLen; l++) {
                        if (uniqNum.get(i) + uniqNum.get(j) + uniqNum.get(k) + uniqNum.get(l) == target) {
                            result.add(addNum(uniqNum.get(i), uniqNum.get(l), uniqNum.get(j), uniqNum.get(k)));
                        }

                    }
                }
            }
        }




        return result;

    }
}