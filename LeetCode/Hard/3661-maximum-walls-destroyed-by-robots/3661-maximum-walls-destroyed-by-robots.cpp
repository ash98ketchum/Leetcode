#define rep(i, a, b) for(ll i = a; i < (b); ++i)
#define all(x) (x).begin(), (x).end()
#define pb push_back
#define f first
#define s second
typedef long long ll;
typedef vector<ll> vl;
typedef pair<ll, ll> pll;

class Solution {
public:
    int maxWalls(vector<int>& robots, vector<int>& distance, vector<int>& walls) {
        ll n = robots.size();
        vector<pll> r(n);
        rep(i, 0, n) r[i] = {robots[i], distance[i]};
        sort(all(r));
        sort(all(walls));

        ll b = 0;
        vl w;
        for(ll x : walls) {
            auto it = lower_bound(all(r), make_pair((ll)x, -1LL));
            if(it != r.end() && it->f == x) b++;
            else w.pb(x);
        }

        ll m = w.size();
        if(m == 0) return b;

        auto calc = [&](ll st, ll en, ll R_val, ll L_val) {
            ll l_idx = upper_bound(all(w), st) - w.begin();
            ll r_idx = lower_bound(all(w), en) - w.begin() - 1;
            if(l_idx > r_idx) return vector<ll>{0, 0, 0};

            ll R_lim = min(en - 1, R_val);
            ll L_lim = max(st + 1, L_val);

            ll mx_R = upper_bound(w.begin() + l_idx, w.begin() + r_idx + 1, R_lim) - w.begin() - 1;
            ll mn_L = lower_bound(w.begin() + l_idx, w.begin() + r_idx + 1, L_lim) - w.begin();

            ll c_R = max(0LL, mx_R - l_idx + 1);
            ll c_L = max(0LL, r_idx - mn_L + 1);
            ll c_RL = (mx_R >= mn_L - 1) ? (r_idx - l_idx + 1) : (c_R + c_L);
            return vector<ll>{c_R, c_L, c_RL};
        };

        ll dp_L = 0, dp_R = 0;
        ll mn_L_0 = lower_bound(all(w), r[0].f - r[0].s) - w.begin();
        ll r_0 = lower_bound(all(w), r[0].f) - w.begin() - 1;
        if(mn_L_0 <= r_0) dp_L = r_0 - mn_L_0 + 1;

        rep(i, 1, n) {
            vector<ll> res = calc(r[i-1].f, r[i].f, r[i-1].f + r[i-1].s, r[i].f - r[i].s);
            ll nxt_L = max(dp_L + res[1], dp_R + res[2]);
            ll nxt_R = max(dp_L, dp_R + res[0]);
            dp_L = nxt_L;
            dp_R = nxt_R;
        }

        ll mx_R_n = upper_bound(all(w), r[n-1].f + r[n-1].s) - w.begin() - 1;
        ll l_n = upper_bound(all(w), r[n-1].f) - w.begin();
        ll c_nR = 0;
        if(mx_R_n >= l_n) c_nR = mx_R_n - l_n + 1;

        return b + max(dp_L, dp_R + c_nR);
    }
};