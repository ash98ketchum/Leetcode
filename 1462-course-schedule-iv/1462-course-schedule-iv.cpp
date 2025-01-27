class Solution {
public:
    set<int>& dfs(int crs, map<int, set<int>>& prereqMap, map<int, vector<int>>& adj) {
        if (prereqMap.find(crs) != prereqMap.end()) {
            return prereqMap[crs];
        }
        prereqMap[crs] = set<int>();
        for (int prereq : adj[crs]) {
            prereqMap[crs].insert(prereq);
            set<int>& prereqSet = dfs(prereq, prereqMap, adj);
            prereqMap[crs].insert(prereqSet.begin(), prereqSet.end());
        }
        
        return prereqMap[crs];
    }

    vector<bool> checkIfPrerequisite(int numCourses, vector<vector<int>>& prerequisites, vector<vector<int>>& queries) {
        map<int, vector<int>> adj;
        for (const auto& edge : prerequisites) {
            adj[edge[1]].push_back(edge[0]);
        }
        map<int, set<int>> prereqMap;
        for (int course = 0; course < numCourses; ++course) {
            dfs(course, prereqMap, adj);
        }

        vector<bool> res;
        for (const auto& query : queries) {
            int course1 = query[0], course2 = query[1];
            if (prereqMap[course2].find(course1) != prereqMap[course2].end()) {
                res.push_back(true);
            } else {
                res.push_back(false);
            }
        }

        return res;
    }
};
