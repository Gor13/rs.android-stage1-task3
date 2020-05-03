package subtask4

import kotlin.random.Random
import java.util.*

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        //  throw NotImplementedError("Not implemented")
        var number = number
        var resultList = mutableListOf<Int>()
        resultList.add(number - 1)

        var list = mutableListOf<Int>()

        var listOfLists = mutableListOf<List<Int>>()
        var isPass = false

        while (!isPass) {
            if (number < 0 || number < 5) {
                return null
            } else {

                while (double(number) - resultList.map { it * it }.sum() > 90) {
                    if (double(number) - resultList.map { it * it }.sum() < 1500)
                        resultList.add(Math.sqrt((double(number) - resultList.map { it * it }
                            .sum()).toDouble()).toInt() - 1)
                    else
                        resultList.add(Math.sqrt((double(number) - resultList.map { it * it }
                            .sum()).toDouble()).toInt())
                }

                for (i in 1..double(number) - resultList.map { it * it }.sum()) {
                    if (double(i) <= double(number) - resultList.map { it * it }.sum()) {
                        list.add(i)

                    }
                }


                var count = 100
                while (count > 0) {
                    Collections.shuffle(list)
                    val curentList = list.take(Random.nextInt(1, list.size)).map { it * it }
                    if (curentList.sum() == double(number) - resultList.map { it * it }.sum()) {
                        count--
                        listOfLists.add(curentList)
                    }
                }

                var lastList = mutableListOf<Int>()
                lastList.add(0)

                for (list in listOfLists) {
                    if (lastList.sum() < list.sum()){
                        lastList = list.toMutableList()
                    } else if (lastList.sum() == list.sum() && lastList.size > list.size){
                        lastList = list.toMutableList()
                    }
                }

                lastList = lastList.map { Math.sqrt(it.toDouble()).toInt() }.toMutableList()
                resultList.addAll(lastList)

            }

            isPass = if (double(number) == resultList.map { it * it }.sum()) true else false
        }

        return resultList.sorted().toTypedArray()

    }

    fun double(x: Int) = x * x
}
