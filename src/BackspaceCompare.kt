class BackspaceCompare {
    fun run() {
        println(backspaceCompare("bxj##tw", "bxo#j##tw"))//true
        println(backspaceCompare("xywrrmp", "xywrrm#p"))//false
        println(backspaceCompare("ab#c", "ad#c")) //true
        println(backspaceCompare("ab##", "c#d#")) //true
        println(backspaceCompare("a##c", "#a#c")) //true
        println(backspaceCompare("a#c", "b")) //false
        println(backspaceCompare("ab###", "c#d#")) //true

    }

    fun backspaceCompare(S: String, T: String): Boolean {
        return remove(T) == remove(S)
    }

    fun remove(S: String): String {
        var si = 0
        var s = S
        while (si < s.length) {
            val numOfBs = countBackspace(si, s)
            if (numOfBs > 0) {
                val begin = Math.max(0, si - numOfBs)
                val end = si + numOfBs - 1
                s = s.removeRange(begin..end)
                si = begin
            }
            si++
        }
        return s
    }

    fun countBackspace(start: Int, s: String): Int {
        var bs = 0
        var i = start
        while (i < s.length && s[i] == '#') {
            bs++
            i++
        }
        return bs
    }
}