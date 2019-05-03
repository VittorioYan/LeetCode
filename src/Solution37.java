import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution37 {
    private List<List<Character>> horIsExist=new ArrayList<>();
    private List<List<Character>> verIsExist=new ArrayList<>();
    private List<List<Character>> everyIsExist=new ArrayList<>();

    boolean isExist(List<Character> chart, Character a){
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

    public boolean isValidSudoku(char[][] board,int i,int j) {
        int nineNo=whichNine(i,j);
        return !(isExist(horIsExist.get(i),board[i][j])||
                isExist(verIsExist.get(j),board[i][j])||
                isExist(everyIsExist.get(nineNo),board[i][j]));
    }

    boolean dp(char[][] board,int i,int j){
        if(i==-1)return true;
        char temp;
        int nineNo=whichNine(i,j);
        int nextI=-1,nextJ=-1;
        for (int jj=j+1;jj<9;jj++){
            if (board[i][jj] == '.') {
                nextI = i;
                nextJ = jj;
                break;
            }
        }
        for(int ii=i+1;ii<9;ii++) {
            if (nextI == -1) {
                for (int jj = 0; jj < 9; jj++) {
                    if (board[ii][jj] == '.') {
                        nextI = ii;
                        nextJ = jj;
                        break;
                    }
                }
            }else break;
        }
        for(int k=1;k<=9;k++){
            temp=(char)(k+'0');
            if(!(isExist(horIsExist.get(i),temp)||
                    isExist(verIsExist.get(j),temp)||
                    isExist(everyIsExist.get(nineNo),temp))){
                horIsExist.get(i).add(temp);
                verIsExist.get(j).add(temp);
                everyIsExist.get(nineNo).add(temp);
                board[i][j]=temp;
                if(dp(board,nextI,nextJ))return true;
                else {
                    horIsExist.get(i).remove(horIsExist.get(i).size()-1);
                    verIsExist.get(j).remove(verIsExist.get(j).size()-1);
                    everyIsExist.get(nineNo).remove(everyIsExist.get(nineNo).size()-1);
                    board[i][j]='.';
                }
            }

        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        char[][] newBoard=new char[9][9];
        for(int i=0;i<9;i++){
            horIsExist.add(new ArrayList<>());
            verIsExist.add(new ArrayList<>());
            everyIsExist.add(new ArrayList<>());
        }

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                newBoard[i][j]=board[i][j];
                if(board[i][j]!='.'){
                    horIsExist.get(i).add(board[i][j]);
                    verIsExist.get(j).add(board[i][j]);
                    everyIsExist.get(whichNine(i,j)).add(board[i][j]);
                }
            }
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') {
                    dp(board,i,j);
                    return;
                }
            }
        }



    }

}