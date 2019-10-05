/* Iterate through a list of trades and transform it to output a list of buy/sell pairs and also //
** calculate overall profit while doing so.
**
** Sample:
** Action       Code      Price       Shares
** BUY          MSFT      65.21         3
** SELL         MSFT      65.31         3
** etc.
**
*/

class Solution {
  class Action {
    int action; // 0 for buy, 1 for sell
    double price;
    int shares;
  }
  //use a HashMap<Code, Action> map to create the Buy, Sell Pairs
  //ITERATE through the list only once
}
