class FirstUniqueTest() {
    fun run() {
        val x = FirstUnique(intArrayOf(2, 3, 5));
        println(x.showFirstUnique()) // return 2
        x.add(5)            // the queue is now [2,3,5,5]
        println(x.showFirstUnique()) // return 2
        x.add(2)            // the queue is now [2,3,5,5,2]
        println(x.showFirstUnique()) // return 3
        x.add(3)           // the queue is now [2,3,5,5,2,3]
        println(x.showFirstUnique()) // return -1

        val y =  FirstUnique(intArrayOf(7,7,7,7,7,7));
        println(y.showFirstUnique()) // return -1
        y.add(7);            // the queue is now [7,7,7,7,7,7,7]
        y.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
        y.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
        y.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
        y.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
        println(y.showFirstUnique()) // return 17
    }

    class FirstUnique(nums: IntArray) {
        val nset = LinkedHashSet<Int>()
        val dups = HashSet<Int>()

        init {
            nums.forEach { add(it) }
        }

        fun showFirstUnique(): Int {
            return if(nset.isEmpty()) -1 else nset.first()
        }

        fun add(value: Int) {
            if (!dups.contains(value) && !nset.contains(value)) {
                nset.add(value)
            } else {
                if (nset.contains(value)) nset.remove(value)
                if (!dups.contains(value)) dups.add(value)
            }
        }
    }
}
