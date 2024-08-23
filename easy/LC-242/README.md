# 有效的字母异位词

解题思路：由于字符串中只有小写字母，因此，我们可以定义一个数组，来统计每个字母出现的次数。

字符串 `s` 统计时，加一。

字符串 `t` 统计时，减一。

如果两个字符串中字母出现的次数一样，那么数组中每个位置的元素应该为零。

具体代码如下：

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }
        for (int i : record) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
```
