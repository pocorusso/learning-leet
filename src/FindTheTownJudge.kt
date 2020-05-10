class FindTheTownJudge {
    fun findJudge(N: Int, trust: Array<IntArray>): Int {
        val set = mutableSetOf<Int>()
        val map = mutableMapOf<Int, MutableSet<Int>>()
        trust.forEach {
            val key = it[0]
            set.add(key)
            map[key] = map.getOrDefault(key, mutableSetOf<Int>()).apply { add(it[1]) }
        }

        var sum = 0
        set.forEach { sum = sum + it }
        val missing = N * (1 + N) / 2 - sum
        trust.forEach {
            val key = it[0]
            if(map.containsKey(key)) {
                if(map[key]?.contains(missing) == false){
                    return -1
                }
            }
        }
        return missing
    }
}