class NumberComplement {
    fun run() {

    }

    fun findComplement(num: Int): Int {
        val bitLength = Integer.toBinaryString(num).length
        return (Math.pow(2.0, bitLength.toDouble()) - 1).toInt() xor num
    }

}