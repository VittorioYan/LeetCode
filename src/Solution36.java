import java.util.ArrayList;
import java.util.List;

class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        List<Character> corresp=new ArrayList<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.')continue;
                if(corresp.contains(board[i][j]))return false;
                else corresp.add(board[i][j]);
            }
            corresp.clear();
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[j][i]=='.')continue;
                if(corresp.contains(board[j][i]))return false;
                else corresp.add(board[j][i]);
            }
            corresp.clear();
        }


        return true;

    }
}