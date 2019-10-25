/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/evaluate-division/

Description:
Equations are given in the format A / B = k, where A and B are variables represented
as strings,
and k is a real number (floating point number). Given some queries, return the
answers. If the
answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0.
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string,
string>> queries , where equations.size() == values.size(), and the values are positive. This
represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].


The input is always valid. You may assume that evaluating the queries will result in no division by
zero and there is no contradiction.

Solution:
First, you take the equations and values and create a map. The key to the map is the string for
the node, and the second map is so that you get constant access to the other nodes that it's
connected to, and the double is either the value or 1/value. This is because a BINARY relationship
is usually represented as a graph. Then, you do DFS, with the numerator and denominator as
the start and the ending of nodes, and try to find the combination.

Runtime: O(knl), where n is the amount of nodes, k is the amount of equations, and l is word
length of the numerator or denominator, since you have to do .equals()
*/

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
      double[] result = new double[queries.size()];
      Map<String, Map<String, Double>> map = constructMap(equations, values);
      for(int i = 0; i < queries.size(); i++) {
        String first = queries.get(i).get(0);
        String second = queries.get(i).get(1);
        double dd = dfs(first, second, 1.0, map, new HashSet<String>());
        result[i] = dd == 0.0 ? -1.0 : dd;
      }
      return result;
    }

    public Map<String, Map<String, Double>> constructMap(List<List<String>> equations, double[] values) {
      Map<String, Map<String, Double>> map = new HashMap<String, Map<String, Double>>();
      for(int i = 0; i < equations.size(); i++) {
        List<String> relation = equations.get(i);
        String first = relation.get(0);
        String second = relation.get(1);
        if(map.get(first) == null) {
          Map<String, Double> temp = new HashMap<>();
          temp.put(second, values[i]);
          map.put(first, temp);
        } else {
          map.get(first).put(second, values[i]);
        }
        if(map.get(second) == null) {
          Map<String, Double> temp = new HashMap<>();
          temp.put(first, 1/values[i]);
          map.put(second, temp);
        } else {
          map.get(second).put(first, 1/values[i]);
        }
      }
      return map;
    }

    public double dfs(String start, String end, double total, Map<String, Map<String, Double>> map,
      Set<String> seen) {
      if(!map.containsKey(start) || !seen.add(start)) {
        return -1.0;
      }
      if(start.equals(end)) {
        return total;
      }
      for(String s : map.get(start).keySet()) {
        double res = dfs(s, end, total * map.get(start).get(s), map, seen);
        if(res != -1.0) {
          return res;
        }
      }
      return -1;
    }
}
