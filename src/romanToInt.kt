//https://leetcode.com/problems/roman-to-integer/

// III = 3
// IV = 4
// IX = 9
// LVIII = 58
// MCMXCIV = 1994
// IV = 4
// IX = 9
// XL = 40
// XC = 90
// CD = 400
// CM = 900

class romanToInt {
    fun run() {
      //  println(romanToInt("III")) //3
        println(romanToInt("IV")) //4
        println(romanToInt("IX")) //9
        println(romanToInt("LVIII")) //58
        println(romanToInt("MCMXCIV")) //1994
        println(romanToInt("XL"))
    }

//    fun romanToInt(s: String): Int {
//        val map: HashMap<String, Int> =
//            hashMapOf(
//                "I" to 1,
//                "V" to 5,
//                "X" to 10,
//                "L" to 50,
//                "C" to 100,
//                "D" to 500,
//                "M" to 1000
//            )
//        val specialMap: HashMap<String, Int> =
//            hashMapOf(
//                "IV" to 4,
//                "IX" to 9,
//                "XL" to 40,
//                "XC" to 90,
//                "CD" to 400,
//                "CM" to 900
//            )
//
//        var sum = 0
//        var index = s.length - 1
//        val sb = StringBuilder()
//        while (index >= 0) {
//            //first check previous
//            var current: String? = null
//            if (index > 0) {
//                current = sb.append(s[index - 1]).append(s[index]).toString()
//            }
//
//            if (current != null) {
//                val partialSum = specialMap[current] ?: 0
//                if (partialSum != 0) {
//                    sum += partialSum
//                    index -= 2
//                } else {
//                    sum += map[s[index].toString()] ?: 0
//                    index--
//                }
//            } else {
//                sum += map[s[index].toString()] ?: 0
//                index--
//            }
//            sb.clear()
//        }
//
//        return sum
//    }

    fun romanToInt(s: String): Int {
        val map: HashMap<String, Int> =
            hashMapOf(
                "I" to 1,
                "V" to 5,
                "X" to 10,
                "L" to 50,
                "C" to 100,
                "D" to 500,
                "M" to 1000
            )

        var sum = 0
        var i = 0
        while (i < s.length) {
            val a = map[s[i].toString()] ?: 0
            if ((i != s.length - 1) && a < map[s[i + 1].toString()] ?: 0) {
                sum += (map[s[i + 1].toString()] ?: 0) - a
                i += 2
            } else {
                sum += a
                i++
            }
        }
        return sum
    }
}
