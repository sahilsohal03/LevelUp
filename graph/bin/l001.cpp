#include <iostream>
#include <vector>

using namespace std;

class Edge {
    public:
        int v;
        int w;
    Edge(int v,int w) {
        this->v = v;
        this->w = w;
    }
}
const int N = 7;
vector<vector<Edge>> graph(N);

void addEdge(int u, int v, int w) {
    graph[u].push_back(Edge(v,w));
    graph[v].push_back(Edge(u,w));
}
void display() {

}

void removeEdge(int u,int v) {

}

void removeVtx(int u) {

}


// Class 27 feb 2021
bool isCycle_DFSTopo(int src, vector<int>& visted,vector<int> &ans) {
    visted[src] = 0;
    bool res = false;
    for(Edge e = graph[src]) {
       if(!visted[e.v] == -1) { 

         res = res || isCycle_DFSTopo(e.v,visted);

       } else if(visted[e.v] == 0) {
           return true
       }

    }
    visted[src] = 1;
    ans.push_back(src);
    return res;
}
void constructGraph() {

    addEdge(0,1,10);
    addEdge(0,3,10);
    addEdge(1,2,10);
    addEdge(2,3,40);
    addEdge(3,4,2);
    addEdge(4,5,2);
    addEdge(4,6,8);
    addEdge(5,6,3);
}

int main() {
    return 0;
}


