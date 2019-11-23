//Default template for Union-Find

class UnionFind {
  public int[] roots;
  public int components;

  //union the roots
  public void union(int node1, int node2) {
    if(find(node1) != find(node2)) {
      components--;
      roots[find(node1)] = roots[find(node2)];
    }
  }

  //finds the root, this utilizes pathCompression
  //draw this one out
  //temp is always the next node
  public int find(int node1) {
    int node = node1;
    while(roots[node] != node) {
      int temp = roots[node];
      roots[node] = roots[temp];
      node = temp;
    }
    return node;
  }

}
