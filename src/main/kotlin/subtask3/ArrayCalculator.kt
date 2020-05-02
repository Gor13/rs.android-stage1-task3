package subtask3
import java.util.*
class ArrayCalculator {

    // TODO: Complete the following function
    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {

        var set = mutableSetOf<Int>()
        val arr = mutableListOf<Int>()
        var result = 0

        for (item in itemsFromArray){
            if (item is Int){
                arr.add(item)
            }
        }

        if (arr.size != 0){
            var count = 10000

            while (count > 0 ){
                Collections.shuffle(arr)
                count--
                var multipliers = 1
                for (a in arr.take(numberOfItems)){
                    multipliers *= a.toInt()
                }
                set.add(multipliers)
            }

            result = set!!.max()!!.toInt()
        }

        return result
    }

    private operator fun Int.times(a: Any): Int {
        return if (a is Int) a else 0
    }

}
