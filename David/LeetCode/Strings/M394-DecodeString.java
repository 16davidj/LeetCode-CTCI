class Solution {
    public String decodeString(String s) {
        int index = 0;
        Stack<Integer> countStk = new Stack<>();
        Stack<String> strStk = new Stack<>();
        char[] charArr = s.toCharArray();
        String res = "";
        while(index < charArr.length) {
            char val = charArr[index];
            if(Character.isDigit(val)) {
                int lead = 0;
                while(Character.isDigit(val)) {
                    lead = lead * 10 + Character.getNumericValue(val);
                    val = charArr[++index];
                }
                countStk.push(lead);
            } else if(val == '[') {
                strStk.push(res);
                res = "";
                index++;
            } else if(val == ']') {
                StringBuilder temp = new StringBuilder(strStk.pop());
                int repeat = countStk.pop();
                int i = 0;
                while(i < repeat) {
                    temp.append(res);
                    i++;
                }
                index++;
                res = temp.toString();
            } else {
                res += val;
                index++;
            }
        }
        return res;
    }
}
