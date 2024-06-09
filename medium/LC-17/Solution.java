class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) return ans;
        Map<Character, String> map = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtracking(ans, map, digits, 0, new StringBuffer());
        return ans;
    }

    public void backtracking(List<String> ans, Map<Character, String> map, String digits, int index, StringBuffer sb) {
        if (index == digits.length()) {
            ans.add(sb.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = map.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                sb.append(letters.charAt(i));
                backtracking(ans, map, digits, index + 1, sb);
                sb.deleteCharAt(index);
            }
        }
    }
}