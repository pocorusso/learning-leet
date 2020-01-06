/**
 * Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
class LengthOfLongestSubstring {
    fun run() {
        //println(lengthOfLongestSubstring("abcabcbb"))
        //println(lengthOfLongestSubstring("bbbbb"))
        //println(lengthOfLongestSubstring("pwwkew"))
        println(lengthOfLongestSubstring("dvdf"))
    }

    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) return 0
        var longest = 1
        for (x in 0..s.length - 1) {
            val existSet = HashSet<Char>()
            var length = 1
            existSet.add(s[x])
            inner@ for (y in (x + 1) until s.length) {
                if (!existSet.contains(s[y])) {
                    length++
                    existSet.add(s[y])
                    if (length > longest) {
                        longest = length
                    }
                } else break@inner
            }
        }
        return longest
    }
}