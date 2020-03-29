class GroupAnagrams {
    fun run() {
        println(groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")))
        println(groupAnagrams(arrayOf("aaa", "ab", "ba", "ab", "aaaa")))
    }

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map: HashMap<Int, MutableList<String>> = hashMapOf()
        for (str in strs) {
            val code = str.toCharArray().sorted().hashCode()
            if (map.containsKey(code)) {
                map[code]!!.add(str)
            } else map[code] = arrayListOf(str)
        }
        return map.values.toList()
    }
}