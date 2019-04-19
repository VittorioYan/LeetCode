import java.util.*;

class Solution30 {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result=new ArrayList<>();
        Map<Integer,Integer> corres=new HashMap<>();

        Arrays.sort(words);
        int sLen=s.length();
        int wordsLen=words.length;
        int[] requireNum=new int[wordsLen];

        String replacement="";
        int wordLen=words[0].length();
        for(int i=0;i<wordLen;i++)replacement+=" ";

        int[] sIndex=new int[sLen];
        for(int i=0;i<sLen;i++)sIndex[i]=-1;

        String sReplace=s;
        for(int i=0;i<words.length;i++){
            if(i>0&&words[i].equals(words[i-1])){
                int j=i;
                while(j<words.length&&words[j].equals(words[i-1])){
                    requireNum[i-1]++;
                    j++;
                }
                i=j;
                continue;

            }
            requireNum[i]++;
            int wordIndex=sReplace.indexOf(words[i]);
            while(wordIndex!=-1){
                for(int j=wordIndex;j<wordIndex+words[i].length();j++){
                    sIndex[j]=i;
                }
                sReplace=sReplace.replaceFirst(words[i],replacement);
                wordIndex=sReplace.indexOf(words[i]);
            }
        }
        List<Integer> newIndex=new ArrayList<>();
        boolean addflag=false;
        int pointer=0;
        for(int i=0;i<sLen;i++){
            if(sIndex[i]>=0){
                addflag=true;
                newIndex.add(sIndex[i]);
                pointer++;
                i+=wordLen-1;
            }else{
                if(addflag){
                    newIndex.add(-1);
                    pointer++;
                    addflag=false;
                }else newIndex.set(pointer-1,newIndex.get(pointer-1)-1);

            }
        }
        int right=wordsLen;
        int sum=0;
        for(int i=0;i<wordsLen;i++){
            if(newIndex.get(i)>0){
                int nowIndex=newIndex.get(i);
                if(corres.containsKey(nowIndex)){
                        int nowSum=corres.get(nowIndex)+1;
                        corres.put(nowIndex,nowSum);
                    if(corres.get(nowIndex)==requireNum[nowIndex]){
                        sum++;
                    }

                }
                else {
                    corres.put(nowIndex,1);
                    sum++;
                }

            }
            if(newIndex.get(i)<0){

            }
        }
        while(right<newIndex.size()){

        }




        return result;

    }
}
