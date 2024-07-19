#include<bits/stdc++.h>
using namespace std;
#define N 100100
typedef long long ll;
ll dp[N][2];
int b[N],w[N],n;
bool visited[N];
vector<int> tree[N];
void dfs(int cur){
    if(visited[cur])
        return;
    visited[cur] = 1;
    dp[cur][1] = w[cur];
    dp[cur][0] = b[cur];
    for(auto next : tree[cur]){
        if(visited[next])
            continue;
        dfs(next);
        dp[cur][0] += dp[next][1];
        dp[cur][1] += min(dp[next][1],dp[next][0]);
    }
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin>>n;
    for(int i=1; i<n; i++){
        int p,c; cin>>p>>c;
        tree[p].push_back(c);
        tree[c].push_back(p);
    }
    for(int i=0; i<n; i++)
        cin>>w[i]>>b[i];
    dfs(0);
    cout << min(dp[0][1],dp[0][0]);
    return 0;
}
