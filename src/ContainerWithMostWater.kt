class ContainerWithMostWater {

    fun run() {
        // 49
        println(maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
    }

    fun maxArea(height: IntArray): Int {
        var maxArea = 0
        var left = 0
        var right = height.size - 1

        while (right > left) {
            val area = Math.min(height[left], height[right]) * (right - left)
            if (area > maxArea) {
                maxArea = area
            }
            if (height[left] >= height[right]) {
                right--
            } else
                left++
        }
        return maxArea
    }

    // Brute forced O(n^2)
//    fun maxArea(height: IntArray): Int {
//        var maxArea = 0
//
//        for(i in 0 until height.size) {
//            for(j in i+1 until height.size) {
//                val y = Math.min(height[i], height[j])
//                val x = j - i
//                val area = x * y
//                if(area > maxArea) {
//                    maxArea = area
//                }
//            }
//        }
//        return maxArea
//    }
}