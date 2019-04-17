import java.util.*;

class Solution17 {
    public List<String> letterCombinations(String digits) {

        List<String> result=new ArrayList<>();
        if(digits.length()==0)return result;
        List<String> midList=new ArrayList<>();
        Map<Character,String> relation=new HashMap<>();
        relation.put('2',"abc");
        relation.put('3',"def");
        relation.put('4',"ghi");
        relation.put('5',"jkl");
        relation.put('6',"mno");
        relation.put('7',"pqrs");
        relation.put('8',"tuv");
        relation.put('9',"wxyz");

        String firstStr=relation.get(digits.charAt(0));
        for(int i=0;i<firstStr.length();i++){
            result.add(firstStr.charAt(i)+"");
        }

        for(int i=1;i<digits.length();i++){
            char theKey=digits.charAt(i);
            String tempStr=relation.get(theKey);
            for (int j=0;j<tempStr.length();j++){
                for(int k = 0 ; k < result.size() ; k++) {
                    midList.add(result.get(k)+tempStr.charAt(j));
                }

            }
            result=midList;
            midList=new ArrayList<>();

        }



        return result;


    }
}