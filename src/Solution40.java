import java.util.*;

class Solution40 {
    List<List<Integer>> result;
    void dp(LinkedList<Integer> route, int target, int[] multi,int point){
        if(target<0)return;
        if(target==0){
            result.add(new LinkedList<>(route));
            route.pollLast();
            return;
        }
        for (int i=point;i<=target;i++){
            if(multi[i]<=0)continue;

            for (int j=multi[i];j>0;j--){
                LinkedList<Integer> temp=new LinkedList<>(route);
                for(int k=0;k<j;k++){
                    temp.add(i);
                }
                int midStore=multi[i];
                multi[i]=0;
                dp(temp,target-i*j,multi,i);
                multi[i]=midStore;

            }
            //route.pollLast();

        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //Arrays.sort(candidates);
        LinkedList<Integer> theRoute=new LinkedList<>();
        result=new LinkedList<>();
//        Map<Integer,Integer> numsCorres=new LinkedHashMap<>();
//        for(int i=0;i<candidates.length;i++){
//            Integer temp=numsCorres.get(candidates[i]);
//            if(temp!=null)numsCorres.put(candidates[i],temp+1);
//            else numsCorres.put(candidates[i],1);
//        }

        int[] multi=new int[target+1];
        for(int i=0;i<candidates.length;i++){
            if(candidates[i]<=target)
                multi[candidates[i]]++;
        }

        dp(theRoute,target,multi,0);
        return result;



    }
}