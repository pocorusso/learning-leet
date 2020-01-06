//https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class LetterCombinationsOfPhoneNumber {
    fun run() {
        println(letterCombinations("23"))
        println(letterCombinations("2222"))
    }

    fun letterCombinations(digits: String): List<String> {
        if(digits.isEmpty()) return listOf()

        val digitToLetters =  mapOf(
            2 to listOf("a", "b", "c"),
            3 to listOf("d", "e", "f"),
            4 to listOf("g", "h", "i"),
            5 to listOf("j", "k", "l"),
            6 to listOf("m", "n", "o"),
            7 to listOf("p", "q", "r", "s"),
            8 to listOf("t", "u", "v"),
            9 to listOf("w", "x", "y", "z")
        )

        val combos = arrayListOf<List<String>>()

        for (i in 0 until digits.length) {
            digitToLetters[digits[i].toString().toInt()]?.apply {
                combos.add(this)
            }
        }

        val result = ArrayList<String>()
        generateCombinations(combos, result, 0, "")
        return result
    }

    fun generateCombinations(lists: List<List<String>>, result: MutableList<String>, depth: Int, current: String ) {
        if(depth == lists.size) {
            result.add(current)
            return
        }
        for (i in 0 until lists.get(depth).size) {
            generateCombinations(lists, result, depth + 1, current + lists[depth].get(i));
        }
    }
}