class FirstUniqueChar {
    fun run() {
        println(firstUniqChar("leetcode")) // 0
        println(firstUniqChar("loveleetcode")) // 2
    }

    fun firstUniqChar(s: String): Int {
        val map = HashMap<Char, Int>()
        s.forEach { c ->
            if (map.contains(c)) {
                map.replace(c, map.getOrDefault(c, -1) + 1)
            } else {
                map.put(c, 1)
            }
        }
        s.forEachIndexed { idx, c ->
            if (map.getOrDefault(c, -1) == 1) return idx
        }
        return -1
    }

//
//    fun firstUniqChar(s: String): Int {
//        val nset = LinkedHashSet<Char>()
//        val dups = HashSet<Char>()
//        val indexes = HashMap<Char, Int>()
//        s.forEachIndexed { idx, value ->
//            indexes.put(value,idx)
//            if (!dups.contains(value) && !nset.contains(value)) {
//                nset.add(value)
//            } else {
//                if (nset.contains(value)) nset.remove(value)
//                if (!dups.contains(value)) dups.add(value)
//            }
//        }
//        return if (nset.isEmpty()) -1 else indexes.getOrDefault(nset.first(), -1)
//    }
}