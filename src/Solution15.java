import java.util.*;

class Solution15 {
    public List<Integer> addNum(int a,int b,int c){
        List<Integer> result=new ArrayList<>();
        result.add(a);
        result.add(b);
        result.add(c);
        return result;
    }


    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;

        List<List<Integer>> result=new ArrayList<>();
        if(n<3)return result;
        Map<Integer,Integer> relation=new LinkedHashMap<>();

        Arrays.sort(nums);
        int[] newNums=new int[n];
        int noReLen=0;
        int zeroFlag=0;

        boolean hasZero=false;
        for(int i=0;i<n;i++){
            if(relation.containsKey(nums[i])){
                relation.put(nums[i],2);
            }
            else relation.put(nums[i],1);
            if(i-2>=0&&nums[i]==0&&nums[i-1]==0&&nums[i-2]==0)relation.put(nums[i],3);
        }
        if(relation.containsKey(0)&&relation.get(0)==3)result.add(addNum(0,0,0));
        Iterator iterator=relation.entrySet().iterator();
        int theKey,theValue;
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            theKey=(Integer) entry.getKey();
            theValue=(Integer) entry.getValue();
            if(theValue==2&&relation.containsKey(0-theKey*2)&&theKey!=0)result.add(addNum(theKey,theKey,0-theKey*2));
            newNums[noReLen]=theKey;
            if(theKey<=0)zeroFlag=noReLen;
            noReLen++;
            System.out.println(entry.getKey());
            //Object key = entry.getKey();
            //Object val = entry.getValue();
        }
        if(newNums[zeroFlag]==0){
            hasZero=true;
            zeroFlag--;
        }

        for(int i=0;i<=zeroFlag;i++){
            for(int j=i+1;j<=zeroFlag;j++){
                int mid=0-newNums[i]-newNums[j];
                if(relation.containsKey(mid)){
                    result.add(addNum(newNums[i],newNums[j],mid));
                }

            }
            if(hasZero){
                if(relation.containsKey(0-newNums[i])){
                    result.add(addNum(newNums[i],0-newNums[i],0));
                }
            }
        }
        if(hasZero)zeroFlag+=2;
        else zeroFlag++;
        for(int i=zeroFlag;i<noReLen;i++){
            for(int j=i+1;j<noReLen;j++){
                int mid=0-newNums[i]-newNums[j];
                if(relation.containsKey(mid)){
                    result.add(addNum(newNums[i],newNums[j],mid));
                }

            }
        }



        return result;
    }
}