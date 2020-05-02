class FirstBadVersion {
    fun run() {
        println(firstBadVersion(5))
    }

    fun firstBadVersion(n: Int): Int {
        var lastBad = -1
        var low = 1
        var high = n

        while (low <= high) {
            val mid = low + (high-low) / 2
            if (isBadVersion(mid)) {
                lastBad = mid
                high = mid - 1
            } else {
                low = mid + 1
            }
        }
        return lastBad
    }

    fun isBadVersion(version: Int): Boolean = version >= 4
}