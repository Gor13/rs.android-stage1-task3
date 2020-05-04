package subtask5

import kotlin.reflect.KClass

class TelephoneFinder {

    // TODO: Complete the following function
    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
       // throw NotImplementedError("Not implemented")
        var resultList = mutableListOf<String>()
        try {
            if (number.toInt() < 0)
                return null
        } catch (ex : Exception){

        }

        var number = number.toCharArray()

        for (digit in 0..number.size - 1){
            when (Character.getNumericValue(number.get(digit))){
                1 -> {
                    resultList.add(mySet(number, digit, '2'))
                    resultList.add(mySet(number, digit, '4'))
                }
                2 -> {
                    resultList.add(mySet(number, digit, '1'))
                    resultList.add(mySet(number, digit, '5'))
                    resultList.add(mySet(number, digit, '3'))
                }
                3 -> {
                    resultList.add(mySet(number, digit, '2'))
                    resultList.add(mySet(number, digit, '6'))
                }
                4 -> {
                    resultList.add(mySet(number, digit, '5'))
                    resultList.add(mySet(number, digit, '1'))
                    resultList.add(mySet(number, digit, '7'))
                }
                5 -> {
                    resultList.add(mySet(number, digit, '2'))
                    resultList.add(mySet(number, digit, '4'))
                    resultList.add(mySet(number, digit, '6'))
                    resultList.add(mySet(number, digit, '8'))
                }
                6 -> {
                    resultList.add(mySet(number, digit, '3'))
                    resultList.add(mySet(number, digit, '5'))
                    resultList.add(mySet(number, digit, '9'))
                }
                7 -> {
                    resultList.add(mySet(number, digit, '4'))
                    resultList.add(mySet(number, digit, '8'))
                }
                8 -> {
                    resultList.add(mySet(number, digit, '5'))
                    resultList.add(mySet(number, digit, '7'))
                    resultList.add(mySet(number, digit, '9'))
                    resultList.add(mySet(number, digit, '0'))
                }
                9 -> {
                    resultList.add(mySet(number, digit, '6'))
                    resultList.add(mySet(number, digit, '8'))
                }
                else -> {
                    resultList.add(mySet(number, digit, '8'))
                }
            }
        }

        return resultList.toTypedArray()
    }

    fun mySet(array: CharArray, index: Int, char: Char) : String {
        var array1 : CharArray
        array1 = array.clone()
        array1.set(index, char)
        return String(array1)
    }
}
