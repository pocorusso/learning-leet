//https://leetcode.com/problems/implement-strstr/
class StrStr {
    fun run() {
        println(strStr("hello", "ll"))
        println(strStr("aaaaaa", "ll"))
        println(strStr("aaa", "a"))
        println(strStr("hello", ""))
        println(strStr("mississippi", "issip"))
        println(strStr("a", "a"))
    }

    fun strStr(haystack: String, needle: String): Int {
        if (needle.length == 0) return 0

        var retval: Int? = null
        var count = 0
        for (i in 0 until haystack.length - needle.length + 1) {
            pointLoop@ for (point in 0 until needle.length) {
                if (needle[point] != haystack[i + point]) {
                    break@pointLoop
                } else count++
            }
            if (count == needle.length) {
                retval = i
                break
            }
            count = 0
        }
        return retval ?: -1
    }
}