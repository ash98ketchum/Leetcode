class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int l=matrix.size();
        for(int i = 0; i<l; i++){
            for(int j = 0; j<l;j++){
                if(i!=j && j<=i){
                    swap(matrix[i][j], matrix[j][i]);

                }
                else{
                    continue;
                }
            }
        }
        for(int i=0; i<l; i++){
            for(int j=0; j<l/2 ; j++){
                
                    swap(matrix[i][j],matrix[i][l-j-1]);
                
                
            }
        
        }
      
    }
};