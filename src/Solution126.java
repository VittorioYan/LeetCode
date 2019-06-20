import java.util.*;

class Solution126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String,List<String>> conMap=new HashMap<>();

        allRoute=new ArrayList<>();
        minStep=Integer.MAX_VALUE;

        if(!wordList.contains(endWord))return allRoute;
        List<String> wordList1=new ArrayList<>(wordList);
        if(!wordList.contains(beginWord))wordList1.add(beginWord);
        int len=beginWord.length();
//生成包含单词连接关系的表
        for(int i=0;i<wordList1.size();i++){
            String flag=wordList1.get(i);
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
//根据连接关系算路径，保存所有路径，并维护最小值
        List<String> route=new ArrayList<>();
        route.add(beginWord);

        Map<String,Integer> allMinStep=new HashMap<>();
        for (String val: noDirMap.keySet()) {
            allMinStep.put(val,Integer.MAX_VALUE);
        }
        allMinStep.put(endWord,1);
        LinkedList<String> queue=new LinkedList<>();
        queue.add(endWord);
        while (!queue.isEmpty()) {
            String temp=queue.poll();
            if(temp.equals(beginWord))break;
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
        if(allMinStep.containsKey(beginWord))
            minStep=allMinStep.get(beginWord);
        else {
            minStep=0;
            return allRoute;
        }


        DFS(allMinStep,noDirMap,beginWord,route,1,endWord);
        return allRoute;


    }
    List<List<String>> allRoute;
    int minStep;

    void DFS(Map<String,Integer> allMinStep,Map<String,List<String>> noDirMap,String theStepWord,List<String> route,int step,String endWord){
        if(theStepWord.equals(endWord)){
            allRoute.add(new ArrayList<>(route));
            return;
        }
        if(step>=minStep)return;
        if(allMinStep.containsKey(theStepWord)&&allMinStep.get(theStepWord)>minStep)return;
        List<String> dictMap=noDirMap.get(theStepWord);
        if(dictMap==null)return;
        for(int i=0;i<dictMap.size();i++){
            String nextWord=dictMap.get(i);
            if(allMinStep.get(nextWord)==minStep-step){
                List<String> temp=new ArrayList<>(route);
                temp.add(nextWord);
                DFS(allMinStep,noDirMap,dictMap.get(i),temp,step+1,endWord);
            }
        }

    }
}