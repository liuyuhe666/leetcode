class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) return ans;
        List<List<String>> dp = new ArrayList<>();
        dp.add(Arrays.asList("none"));
        dp.add(Arrays.asList("()"));
        for (int i = 2; i < n + 1; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> list1 = dp.get(j);
                List<String> list2 = dp.get(i - 1 - j);
                for (String k1 : list1) {
                    for (String k2 : list2) {
                        if (k1 == "none") {
                            k1 = "";
                        }
                        if (k2 == "none") {
                            k2 = "";
                        }
                        String s = "(" + k1 + ")" + k2;
                        list.add(s);
                    }
                }
            }
            dp.add(list);
        }
        return dp.get(n);
    }
}