import java.util.*;

class Solution127 {
    List<List<String>> allRoute;
    int minStep;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String,List<String>> conMap=new HashMap<>();

        allRoute=new ArrayList<>();
        minStep=Integer.MAX_VALUE;

        if(!wordList.contains(endWord))return 0;
        if(!wordList.contains(beginWord))wordList.add(beginWord);
        int[][] dp=new int[wordList.size()+1][wordList.size()+1];
        int len=beginWord.length();
//生成包含单词连接关系的表
        for(int i=0;i<wordList.size();i++){
            String flag=wordList.get(i);
            for(int j=0;j<len;j++){
                String temp=flag.substring(0,j)+'*'+flag.substring(j+1);
                if(!conMap.containsKey(temp)){
                    List<String> aNewList=new ArrayList<>();
                    aNewList.add(flag);
                    conMap.put(temp,aNewList);
                }else{
                    conMap.get(temp).add(flag);
                }
            }
        }
//连接关系转换为无向图
        Map<String,List<String>> noDirMap=new HashMap<>();
        for( List<String> val:conMap.values()){
            int VSize=val.size();
            if(VSize<=1)continue;
            List<String> temp;
            for(int i=0;i<VSize;i++){
                if(!noDirMap.containsKey(val.get(i))){
                    temp=new ArrayList<>();
                }else {
                    temp=noDirMap.get(val.get(i));
                }

                for(int j=0;j<VSize;j++){
                    if(j==i)continue;
                    if(!temp.contains(j)) {
                        temp.add(val.get(j));
                    }
                }
                noDirMap.put(val.get(i),temp);
            }
        }
//根据连接关系算路径
        List<String> route=new ArrayList<>();
        List<List<String>> result=new ArrayList<>();
        route.add(beginWord);

        Map<String,Integer> allMinStep=new HashMap<>();
        for (String val: noDirMap.keySet()) {
            allMinStep.put(val,Integer.MAX_VALUE);
        }
        allMinStep.put(beginWord,1);
        LinkedList<String> queue=new LinkedList<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            String temp=queue.poll();
            if(temp.equals(endWord))break;
            List<String> dictMap=noDirMap.get(temp);
            if(dictMap==null)continue;
            for(int i=0;i<dictMap.size();i++) {
                String nextWord = dictMap.get(i);
                if(allMinStep.containsKey(nextWord))
                {
                    if(allMinStep.get(nextWord)>allMinStep.get(temp)+1){
                        allMinStep.put(nextWord,allMinStep.get(temp)+1);
                        queue.add(nextWord);
                    }
                }
            }
        }
        if(allMinStep.containsKey(endWord))
            minStep=allMinStep.get(endWord);
        else minStep=0;
        return minStep;

    }
}