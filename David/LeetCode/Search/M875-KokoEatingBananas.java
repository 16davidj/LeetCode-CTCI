/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/koko-eating-bananas/

Description: Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has piles[i]
bananas.  The guards have gone and will come back in H hours.

Koko can decide her bananas-per-hour eating speed of K.  Each hour, she chooses some pile of
bananas, and eats K bananas from that pile.  If the pile has less than K bananas, she eats all of
them instead, and won't eat any more bananas during this hour.

Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come
back.

Return the minimum integer K such that she can eat all the bananas within H hours.

Example 1:

Input: piles = [3,6,7,11], H = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], H = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], H = 6
Output: 23


Note:

1 <= piles.length <= 10^4
piles.length <= H <= 10^9
1 <= piles[i] <= 10^9

Solution:
Same type of solution as M1011 and H410, where you have to search for a specific number in a given
interval, except the predicate is whether or not you can eat it within a given amount of hours
given your speed.

Runtime: O(n * log (max pile))

Space Complexity: O(1)

*/

class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int min = 1;
        int max = 0;
        for(int pile : piles) {
            min = Math.min(min, pile);
            max = Math.max(max, pile);
        }

        int lo = min;
        int hi = max;
        while(lo < hi) {
            int mid = (lo + hi)/2;
            if(canEatAll(piles, mid, H)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return (int) lo;
    }

    private boolean canEatAll(int[] piles, int speed, int H) {
        int hours = 0;
        for(int pile : piles) {
            hours += Math.ceil(pile/(double)speed);
            if(hours > H) {
                return false;
            }
        }
        return true;
    }
}
