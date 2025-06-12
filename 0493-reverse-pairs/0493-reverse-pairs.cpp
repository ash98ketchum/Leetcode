#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
using namespace std;
using namespace __gnu_pbds;

// allow duplicates by pairing with a unique id
using ordered_set = tree<
    pair<long long,int>,
    null_type,
    less<pair<long long,int>>,
    rb_tree_tag,
    tree_order_statistics_node_update
>;

class Solution {
public:
    int reversePairs(vector<int>& nums) {
        ordered_set os;
        int uid = 0;
        long long ans = 0;
        
        for (int x : nums) {
            long long thresh = 2LL * x;
            int cnt = os.size()
                    - os.order_of_key({ thresh + 1, 0 });
            ans += cnt;
            
            os.insert({ x, uid++ });
        }
        
        return (int)ans;
    }
};
