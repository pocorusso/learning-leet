class ReverseString {
    fun run() {
        var s = charArrayOf('a', 'b', 'c', 'd', 'e')
        reverseString(s)
        println(s)

        s = charArrayOf('a', 'b', 'c', 'd', 'e','f')
        reverseString(s)
        println(s)

        s = charArrayOf('h', 'e', 'l', 'l', 'o')
        reverseString(s)
        println(s)

        s = charArrayOf('H', 'a', 'n', 'n', 'a', 'h')
        reverseString(s)
        println(s)

    }

    fun reverseString(s: CharArray): Unit {
        for (i in 0 until s.size/2) {
            val temp = s[i]
            s[i] = s[s.lastIndex - i]
            s[s.lastIndex - i] = temp
        }
    }
}