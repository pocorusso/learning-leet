class RansomeNote {
    fun run() {
        println(canConstruct("a", "b")) //false
        println(canConstruct("aa", "aab")) //true
    }

    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val map = HashMap<Char, Int>()
        magazine.forEach {
            if (map.containsKey(it)) {
                map.replace(it, map.getValue(it) + 1)
            } else map[it] = 1
        }
        ransomNote.forEach {
            if (map.getOrDefault(it, 0) == 0) return false
            map.replace(it, map.getValue(it) - 1)
        }
        return true
    }
}