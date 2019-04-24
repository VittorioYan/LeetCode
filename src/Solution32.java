import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution32 {
    public int longestValidParentheses(String s) {
        int result=0;
        int bracketsPoint=s.indexOf("()");
        if(bracketsPoint==-1)return 0;
        List<Integer> replaceIndex=new ArrayList<>();
        while(bracketsPoint!=-1){
            replaceIndex.add(bracketsPoint);
            s=s.replaceFirst("\\(\\)","");
            bracketsPoint=s.indexOf("()");
        }
        int length=replaceIndex.size();
        Map<Integer,Integer> max=new HashMap<>();
        int[] num=new int[length];
        num[0]=2;
        for(int i=1;i<length;i++){
            int temp=replaceIndex.get(i);
            if(temp>replaceIndex.get(i-1)){
                max.put(replaceIndex.get(i-1),num[i-1]);
                num[i]=2;
            }
            else if(temp==replaceIndex.get(i-1)){
                num[i]=num[i-1]+2;
            }
            else {
                if(max.containsKey(temp)){
                    num[i]=num[i-1]+max.get(temp)+2;
                    max.remove(temp);
                }else num[i]=num[i]=num[i-1]+2;
            }
        }
        for (int i=0;i<length;i++){
            result=result>num[i]?result:num[i];
        }


        return result;


    }
}