//https://leetcode.com/problems/longest-common-subsequence/
class LongestCommonSubsequence {
    fun run() {
        println(longestCommonSubsequence("abcde", "ace")) //3
        println(longestCommonSubsequence("abc", "abc")) //3
        println(longestCommonSubsequence("abc", "def")) //0
    }

    //DP[i][j] = DP[i - 1][j - 1] + 1 , if text1[i] == text2[j] DP[i][j] = max(DP[i - 1][j], DP[i][j - 1]) , otherwise
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val dp = Array(text1.length + 1) { Array(text2.length + 1) { 0 } }
        val m = text1.length
        val n = text2.length
        for (i in 1..m) {
            for (j in 1..n) {
                if (text1[i - 1] == text2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])
            }
        }
        return dp[m][n]
    }
}