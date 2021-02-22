class FindLongestWord {
    fun run() {
        println(findLongestWord("bab", listOf("ba", "ab", "a", "b")))
        println(findLongestWord("abpcplea", listOf("ale", "apple", "monkey", "plea")))
        println(findLongestWord("abpcplea", listOf("a", "b", "c")))
        println(findLongestWord("abpcplea", listOf("x", "y", "z")))
        println(findLongestWord("abpcplea", listOf("plea", "y", "z")))

    }

    fun findLongestWord(s: String, d: List<String>): String {
        var longestWord = ""
        d.forEach { word ->
            if (word.length >= longestWord.length) {
                var sStart = 0
                var dStart = 0
                var letterCount = 0
                for (i in dStart until word.length) {
                    for (j in sStart until s.length) {
                        if (word[i] == s[j]) {
                            letterCount++
                            sStart = j + 1
                            dStart++
                            break;
                        }
                    }
                }
                if (letterCount == word.length
                    && (letterCount > longestWord.length
                    || (longestWord.length == word.length && word.compareTo(longestWord) < 0))
                ) {
                    longestWord = word
                }
            }
        }
        return longestWord
    }
}