class Solution {
    
    bool check(char ch,int r,int c,vector<vector<char>>&board){
        //check for present row;
        for(int j=0;j<9;j++){
            if(board[r][j]==ch)return false;
        }
        //check for present column
        for(int i=0;i<9;i++){
            if(board[i][c]==ch)return false;
        }
        //checking the 3*3 square
        int temp1=r-(r%3);
        int temp2=c-(c%3);
        for(int i=temp1;i<temp1+3;i++){
            for(int j=temp2;j<temp2+3;j++){
                if(board[i][j]==ch)return false;
            }
        }
        
        return true;
        
    }
    bool solve(vector<vector<char>>& board,int i,int j){
        if(i==9)return true;
        if(j==9){
            return solve(board,i+1,0);
        }
        if(board[i][j]!='.'){
            return solve(board,i,j+1);
        }
        
        for(char c='1';c<='9';c++){
            if(!check(c,i,j,board))continue;
            board[i][j]=c;
            bool ans=solve(board,i,j+1);
            if(ans==true){
                return true;
            }
            else{
                board[i][j]='.';
            }
        }
        return false;
    }
public:
    void solveSudoku(vector<vector<char>>& board) {
        solve(board,0,0);
    }
};