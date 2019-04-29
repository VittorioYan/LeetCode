import java.util.ArrayList;
import java.util.List;

class Solution36 {
    boolean isExist(List<Character> chart,Character a){
        if(chart.contains(a))return true;
        else return false;
    }
    int whichNine(int i,int j){
        if(i<3&&j<3)return 0;
        if(i<3&&j<6)return 1;
        if(i<3)return 2;
        if(i<6&&j<3)return 3;
        if(i<6&&j<6)return 4;
        if(i<6)return 5;
        if(j<3)return 6;
        if(j<6)return 7;
        return 8;


    }

    public boolean isValidSudoku(char[][] board) {
        List<List<Character>> horIsExist=new ArrayList<>();
        List<List<Character>> verIsExist=new ArrayList<>();
        List<List<Character>> everyIsExist=new ArrayList<>();

        for(int i=0;i<9;i++){
            horIsExist.add(new ArrayList<>());
            verIsExist.add(new ArrayList<>());
            everyIsExist.add(new ArrayList<>());
        }

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.')continue;
                if(!isExist(horIsExist.get(i),board[i][j])){
                    horIsExist.get(i).add(board[i][j]);
                }else return false;
                if(!isExist(verIsExist.get(j),board[i][j])){
                    verIsExist.get(j).add(board[i][j]);
                }else return false;
                int nineNo=whichNine(i,j);
                if(!isExist(everyIsExist.get(nineNo),board[i][j])){
                    everyIsExist.get(nineNo).add(board[i][j]);
                }else return false;

            }
        }


        return true;

    }
}