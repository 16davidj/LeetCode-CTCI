/*
https://leetcode.com/discuss/interview-question/364396/Google-or-Phone-Screen-or-Moving-Product-from-Data-Stream

All methods should work in O(1) time.

Example:

SlidingWindow window = new SlidingWindow(3);
window.add(1); // [1]
window.add(2); // [1, 2]
window.getProduct(); // 2
window.add(3); // [1, 2, 3]
window.getProduct(); // 6
window.add(4); // [2, 3, 4]
window.getProduct(); // 24
Follow-up:
What if k is a method argument instead of constructor?

You can assume that a product will fit into a single 32-bit integer without overflowing.
*/

class SlidingWindow {
    Queue<Integer> queue;
    int product;
    int numZeros;
    int lastK;
    public SlidingWindow(int k) {
      queue = new LinkedList<>();
      product = 1;
      numZeros = 0;
      lastK = k;
    }

    public void add(int val) {
      if(lastK < 1) {
        return;
      }
      if(val == 0) {
        numZeroes++;
      } else {
        product *= val;
      }
      if(queue.size() >= k) {
        int divisor = queue.poll();
        if(divisor == 0) {
          numZeroes--;
        } else {
          product /= divisor;
        }
      }
      queue.add(val);
    }

	   public int getProduct() {
       if(queue.size() == 0 || numZeroes > 0) {
         return 0;
       }
       return product;
	    }

}

class SlidingWindow2 {
    int kElements;
    List<Integer> leftmostProduct;
    int rightIdxOfZero;
    public SlidingWindow(int k) {
      kElements = k;
      leftmostProduct = new ArrayList<>();
      rightIdxOfZero = 0;
    }

    public void add(int val) {
      if(val == 0) {
        rightIdxOfZero = leftmostProduct.size();
        leftmostProduct = leftmostProduct.get(leftmostProduct.size() - 1);
      } else {
        leftmostProduct.add(leftmostProduct.get(leftmostProduct.size() - 1) * val);
      }
    }
    public int getProduct(int k) {
      if(rightIdxOfZero >= nums.length - k) {
        return 0;
      } else {
        return leftmostProduct.get(leftmostProduct.size() - 1) / leftmostProduct.get(leftmostProduct.size() - k - 1);
      }
    }
}
