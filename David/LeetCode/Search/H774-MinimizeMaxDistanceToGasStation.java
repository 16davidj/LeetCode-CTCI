/*
Difficulty: Hard
Problem Link: https://leetcode.com/problems/minimize-max-distance-to-gas-station/

Description:
On a horizontal number line, we have gas stations at positions stations[0], stations[1], ...,
stations[N-1], where N = stations.length.

Now, we add K more gas stations so that D, the maximum distance between adjacent gas stations, is
minimized.

Return the smallest possible value of D.

Example:

Input: stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], K = 9
Output: 0.500000
Note:

stations.length will be an integer in range [10, 2000].
stations[i] will be an integer in range [0, 10^8].
K will be an integer in range [1, 10^6].
Answers within 10^-6 of the true value will be accepted as correct.

Solution: Similar to H410, M875, M1011 questions, where it's a binary search, except the predicate 
function is now whether or not the distance is large enough to have that many stations be placed.
If it's not, then you need to increase the distance to make it require less tations. If it is, then
keep going down.

Runtime: O(n log(max distance))

Space Complexity: O(1)

*/

class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        double min = 0.0;
        double max = 1e8;
        for(int i = 1; i < stations.length; i++) {
            max = (double) Math.max(stations[i] - stations[i - 1], max);
        }

        double lo = min;
        double hi = max;
        while(lo + 1e-6 < hi) {
            double mid = (lo + hi)/2;
            if(isPlaceable(stations, mid, K)) {
                hi = mid;
            } else {
                lo = mid + 1e-6;
            }
        }
        return lo;
    }

    private boolean isPlaceable(int[] stations, double distance, int K) {
        int needed = 0;
        for(int i = 1; i < stations.length; i++) {
            int dist = stations[i] - stations[i-1];
            needed += Math.ceil(dist/distance) - 1;
            if(needed > K) {
                return false;
            }
        }
        return true;
    }
}
