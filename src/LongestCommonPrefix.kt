//https://leetcode.com/problems/longest-common-prefix/
class LongestCommonPrefix {
    fun run() {
        println(longestCommonPrefix(arrayListOf("flower", "flow", "flight").toTypedArray()))
        println(longestCommonPrefix(arrayListOf("dog", "racecar", "car").toTypedArray()))
        println(longestCommonPrefix(arrayListOf("ttt", "tyyy", "tyy").toTypedArray()))
        println(longestCommonPrefix(arrayListOf("c", "c").toTypedArray()))
    }

    fun longestCommonPrefix(strs: Array<String>): String {
        if(strs.isEmpty()) return ""
        if(strs.size == 1) return strs[0]

        var isFinished = false;

        var prefix = ""
        var currentIndex = 0
        loop@ while (!isFinished) {
            var letter = '\n'
            if (strs[0].isEmpty() || currentIndex > strs[0].length - 1) {
                isFinished = true
            } else {
                letter = strs[0][currentIndex]
                for (i in 1 until strs.size) {
                    if (currentIndex > strs[i].length - 1 ||
                        letter != strs[i][currentIndex]
                    ) {
                        isFinished = true
                        break@loop
                    }
                    //make it to the end without breaking
                    if (i == strs.size - 1) {
                        prefix += letter
                    }
                }
            }
            currentIndex++
        }
        return prefix
    }
}