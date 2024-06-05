class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int m = num1.length(), n = num2.length();
        for (int i = n - 1; i >= 0; i--) {
            StringBuffer curr = new StringBuffer();
            int carry = 0;
            // 补零
            for (int j = n - 1; j > i; j--) {
                curr.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int prod = x * y + carry;
                curr.append(prod % 10);
                carry = prod / 10;
            }
            if (carry != 0) {
                curr.append(carry % 10);
            }
            ans = add(ans, curr.reverse().toString());
        }
        return ans;
    }

    public String add(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int res = x + y + carry;
            ans.append(res % 10);
            carry = res / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }
}