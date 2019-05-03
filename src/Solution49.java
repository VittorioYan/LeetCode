import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution49 {
    List<List<String>> results;
    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> corres=new ArrayList<>();
        List<String> result;
        results=new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            char[] temp=strs[i].toCharArray();
            Arrays.sort(temp);
            String isExist=String.valueOf(temp);
            int point=corres.indexOf(isExist);
            if(point!=-1){
                results.get(point).add(strs[i]);
            }else {
                corres.add(isExist);
                result=new ArrayList<>();
                result.add(strs[i]);
                results.add(result);
            }

        }
        return results;
    }
}