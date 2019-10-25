/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/

Description: Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

Example 1:

Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]

     0          3
     |          |
     1 --- 2    4

Output: 2
Example 2:

Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]

     0           4
     |           |
     1 --- 2 --- 3

Output:  1
Note:
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1]
is the same as [1, 0] and thus will not appear together in edges.

Solution: Union-Find

Notes about union-find: you need to create a root array and number of components to begin with,
where each index in the root array has a value that represents the root of the node. initialize
them to itself

Then, union the nodes based on the amount of connections they have using find. Path compression
happens in find, where you need to set the root to the one above, and keep going

find returns the root of the node, so you can use that in union.

Runtime: O(n), where m is the number of union-find operations and n is the amount of
objects

Space Complexity: O(n)

*/

class Solution {
    int components;
    public int countComponents(int n, int[][] edges) {
        int [] roots = new int[n];
        for(int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }
        components = n;
        for(int[] edge : edges) {
            union(roots, edge[0], edge[1]);
        }
        return components;
    }

    public void union(int[] root, int setX, int setY) {
        if(find(root, setX) != find(root, setY)) {
            root[find(root,setX)] = root[find(root, setY)];
            components -= 1;
        }
    }

    public int find(int[] root, int node) {
        while(root[node] != node) {
            //path compression
            int temp = root[node];
            root[node] = root[root[node]];
            node = temp;
        }
        return node;
    }
}
