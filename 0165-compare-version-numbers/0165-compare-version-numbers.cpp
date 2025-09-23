class Solution {
public:
    int compareVersion(string version1, string version2) {
        int m = version1.length();
        int n = version2.length();
        int i = 0, j = 0;
        
        while (i < m || j < n) {
            long long temp1 = 0, temp2 = 0;
            
            while (i < m && version1[i] != '.') {
                temp1 = temp1 * 10 + (version1[i] - '0');
                i++;
            }
            
            while (j < n && version2[j] != '.') {
                temp2 = temp2 * 10 + (version2[j] - '0'); 
                j++;
            }
            
            if (temp1 > temp2) return 1;
            else if (temp1 < temp2) return -1;
            
            i++; 
            j++;
        }
        
        return 0;
    }
};