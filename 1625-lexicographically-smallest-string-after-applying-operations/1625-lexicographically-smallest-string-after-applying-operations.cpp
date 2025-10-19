class Solution {
public:
    string addop(string s, int a){
        string res = s;
        for(int i = 1; i < res.size(); i+=2){
            res[i] = ((res[i] - '0' + a) % 10) + '0';
        }
        return res;
    }
    string rotateop(string s, int b){
        return s.substr(b) + s.substr(0,b);
    }
    string findLexSmallestString(string s, int a, int b) {
        set<string> visited;
        queue<string> q;
        q.push(s);
        visited.insert(s);
        string ans = s;
        while(!q.empty()){
            string curr = q.front();
            q.pop();
            ans = min(ans, curr);
            // add
            string s1 = addop(curr, a);
            if(visited.find(s1) == visited.end()){
                q.push(s1);
                visited.insert(s1);
            }
            //rotate
            string s2 = rotateop(curr, b);
            if(visited.find(s2) == visited.end()){
                visited.insert(s2);
                q.push(s2);
            }
        }
        return ans;

    }
};