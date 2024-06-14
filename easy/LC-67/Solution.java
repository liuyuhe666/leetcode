class Solution {
    public String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();
        int l1 = a.length(), l2 = b.length();
        int n = Math.max(l1, l2), carry = 0;
        for (int i = 0; i < n; i++) {
            carry += i < l1 ? (a.charAt(l1 - 1 - i) - '0') : 0;
            carry += i < l2 ? (b.charAt(l2 - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }
        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();
        return ans.toString();
    }
}