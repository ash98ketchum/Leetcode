class Solution {
public:
    int countCollisions(string s) {
        vector<char> st;
        int cnt = 0;
        
        for(char c : s) {

            if(c == 'L') {
                // Case 1: R ... L → head-on collision
                if(!st.empty() && st.back() == 'R') {
                    cnt += 2;              
                    st.pop_back();         
                    // After collision becomes S
                    while(!st.empty() && st.back() == 'R') {
                        cnt++;             // Additional collisions
                        st.pop_back();
                    }
                    st.push_back('S');
                }
                // Case 2: S ... L → side collision
                else if(!st.empty() && st.back() == 'S') {
                    cnt++; 
                }
                else {
                    // pure L with no collision → move on
                }
            } 
        
            else if(c == 'R') {
                st.push_back('R');
            }

            else { // c == 'S'
                // Any R behind S will collide
                while(!st.empty() && st.back() == 'R') {
                    cnt++;
                    st.pop_back();
                }
                st.push_back('S');
            }
        }
        return cnt;
    }
};
