class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length, m = board[0].length;
        
        
        
        //row 
        for(int i = 0; i < n; i++){
            HashMap<Character, Integer> row = new HashMap<>();
            for(int j = 0; j < m; j++){
               if(board[i][j] != '.'){
                  row.put(board[i][j], row.getOrDefault(board[i][j], 0) + 1);
               }
            }
            for(int it: row.values()){
                if(it >= 2){
                    return false;
                }
            }
        }
        
        //col
        for(int i = 0; i < m; i++){
            HashMap<Character, Integer> col = new HashMap<>();
            for(int j = 0; j < n; j++){
               if(board[j][i] != '.'){
                  col.put(board[j][i], col.getOrDefault(board[j][i], 0) + 1);
               }
            }
            for(int it: col.values()){
                if(it >= 2){
                    return false;
                }
            }
        }
        
        //box
        // (0,0), (0,3), (0,6)
        // (3,0), (3,3), (3,6)
        // (6,0), (6,3), (6,6)

        for(int i = 0; i < n; i+=3){
            for(int j = 0; j < m; j+= 3){
                HashMap<Character, Integer> box = new HashMap<>();

                for(int r = i; r < i + 3; r++){
                    for(int c = j; c < j + 3; c++){
                        if(board[r][c] != '.'){
                            box.put(board[r][c], box.getOrDefault(board[r][c], 0) + 1);
                        }
                    }
                    
                }
                for(int it : box.values()){
                    if(it >= 2) return false;
                }
                
            }
        }
        
        
        return true;
    }
}